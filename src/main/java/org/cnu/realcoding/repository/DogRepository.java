package org.cnu.realcoding.repository;

import com.mongodb.client.result.UpdateResult;
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

    /* 삽입 */
    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
    }

    /* 조회 */
    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        return mongoTemplate.findOne(
                Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                Dog.class
        );
    }

    /* 수정 */
    public Dog modifyWithAddingDogRecord(String name, List<String> newRecords) {
        Query query = new Query().addCriteria(Criteria.where("name").is(name));
        Update update = new Update().push("medicalRecords").each(newRecords);
        return mongoTemplate.findAndModify(query, update, Dog.class);
    }
}
