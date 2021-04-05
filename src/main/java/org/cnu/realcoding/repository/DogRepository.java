package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {
    private List<Dog> dogs = new ArrayList<>();

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
        for(Dog dog: dogs) {
            if(dog.getName().equals(name)) {
                List<String> oldRecords = dog.getMedicalRecords();
                List<String> records = new ArrayList<>();
                records.addAll(oldRecords);
                records.addAll(newRecords);

                dog.setMedicalRecords(records);
                return dog;
            }
        }
        return null;
    }
}
