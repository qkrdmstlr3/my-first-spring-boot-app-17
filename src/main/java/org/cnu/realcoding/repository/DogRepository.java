package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    /* 생성 */
    public Boolean insertDog(Dog dog) {
        Query query = new Query(
                Criteria.where("name").is(dog.getName())
                        .and("ownerName").is(dog.getOwnerName())
                        .and("ownerPhoneNumber").is(dog.getOwnerPhoneNumber())
        );

        Boolean dogExists = mongoTemplate.findOne(query, Dog.class) != null;
        if (!dogExists) {
            mongoTemplate.insert(dog);
            return true;
        }
        return false;
    }


    /* 조회 */
    public List<Dog> getDogByOwnerName(String ownerName) {
        return mongoTemplate.find(
                Query.query(Criteria.where("ownerName").is(ownerName)),
                Dog.class
        );
    }

    public List<Dog> getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        return mongoTemplate.find(
                Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                Dog.class
        );
    }

    /* 수정 */
    public Dog modifyDogKind(String name, String ownerName, String ownerPhoneNumber, String kind) {

        Query query = new Query(Criteria.where("name").is(name)
                .and("ownerName").is(ownerName)
                .and("ownerPhoneNumber").is(ownerPhoneNumber)
        );

        Update update = Update.update("kind", kind);

        mongoTemplate.updateFirst(query, update, Dog.class);
    }
  
    public Dog modifyWithAddingDogRecord(String name, String ownerName, String ownerPhoneNumber, List<String> newRecords) {
        Query query = new Query(Criteria.where("name").is(name)
                .and("ownerName").is(ownerName)
                .and("ownerPhoneNumber").is(ownerPhoneNumber)
        );
        Update update = new Update().push("medicalRecords").each(newRecords);
        return mongoTemplate.findAndModify(query, update, Dog.class);
    }
}