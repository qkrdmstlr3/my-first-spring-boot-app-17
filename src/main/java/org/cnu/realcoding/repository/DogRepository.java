package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {
    private List<Dog> dogs = new ArrayList<>();

    /* 삽입 */
    public void insertDog(Dog dog) {
        dogs.add(dog);
    }

    /* 조회 */
    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        return dogs.stream()
                .filter(dog -> dog.getOwnerPhoneNumber().equals(ownerPhoneNumber))
                .findFirst()
                .orElse(null);
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
