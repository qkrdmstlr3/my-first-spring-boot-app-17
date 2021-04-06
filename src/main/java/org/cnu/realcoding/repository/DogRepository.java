package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
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

        boolean dogExists = mongoTemplate.findOne(query, Dog.class) != null;
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
    public List<Dog> getDogByDogName(String name){
        return mongoTemplate
                .find(
                        Query.query(Criteria.where("name").is(name)),
                        Dog.class
                        );
    }
    public Dog getDogByThreeParams(String name, String ownername, String ownerphonenumber)
    {
        //return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), Dog.class);
        if((mongoTemplate.findOne(Query.query(  Criteria.where("name").is(name)  ), Dog.class) !=null))
            if((mongoTemplate.findOne(Query.query(  Criteria.where("ownerName").is(ownername)  ), Dog.class) !=null) )
                if((mongoTemplate.findOne(Query.query(  Criteria.where("ownerPhoneNumber").is(ownerphonenumber)  ), Dog.class) !=null))
                 return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), Dog.class);



        return null;
    }

    /* 수정 */
    public Dog modifyDogKind(String name, String ownerName, String ownerPhoneNumber, String kind) {

        Query query = new Query(Criteria.where("name").is(name)
                .and("ownerName").is(ownerName)
                .and("ownerPhoneNumber").is(ownerPhoneNumber)
        );

        Update update = Update.update("kind", kind);

        return mongoTemplate.findAndModify(query, update, Dog.class);
    }
  
    public Dog modifyWithAddingDogRecord(String name, String ownerName, String ownerPhoneNumber, List<String> newRecords) {
        Query query = new Query(Criteria.where("name").is(name)
                .and("ownerName").is(ownerName)
                .and("ownerPhoneNumber").is(ownerPhoneNumber)
        );
        Update update = new Update().push("medicalRecords").each(newRecords);
        return mongoTemplate.findAndModify(query, update, Dog.class);
    }
    public Dog modifyWithAll(Dog dog, Dog modifyDog) {
        boolean isMedicalRecordsAuthorized = modifyDog.getMedicalRecords() == null || Arrays.equals(modifyDog.getMedicalRecords().toArray(), dog.getMedicalRecords().toArray());
        if(isMedicalRecordsAuthorized){
            String name = dog.getName();
            String ownerName = dog.getOwnerName();
            String ownerPhoneNumber = dog.getOwnerPhoneNumber();
            Query query = new Query(Criteria.where("name")
                    .is(name)
                    .and("ownerName").is(ownerName)
                    .and("ownerPhoneNumber").is(ownerPhoneNumber)
            );
            name = modifyDog.getName();
            ownerName = modifyDog.getOwnerName();
            ownerPhoneNumber = modifyDog.getOwnerPhoneNumber();
            String kind = modifyDog.getKind();

            Update update = new Update();
            if(name != null) {
                update.set("name", name);
            }
            if(ownerName != null) {
                update.set("ownerName", ownerName);
            }
            if(ownerPhoneNumber != null) {
                update.set("ownerPhoneNumber", ownerPhoneNumber);
            }
            if(kind != null) {
                update.set("kind", kind);
            }
            return mongoTemplate.findAndModify(query, update, Dog.class);
        }
        return null;
    }
}
