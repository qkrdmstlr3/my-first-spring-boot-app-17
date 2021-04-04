package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DogRepository {
    private List<Dog> dogs = new ArrayList<>();

    public void insertDog(Dog dog) {
        dogs.add(dog);
    }

    public Dog getDogName(String name){
        return dogs.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Dog modifyWithAll(Dog dog, Dog modDog) {

        if(modDog.getMedicalRecords() == null || Arrays.equals(modDog.getMedicalRecords().toArray(), dog.getMedicalRecords().toArray())){
            dog.setName(modDog.getName());
            dog.setKind(modDog.getKind());
            dog.setOwnerName(modDog.getOwnerName());
            dog.setOwnerPhoneNumber(modDog.getOwnerPhoneNumber());
            return dog;
        }
        return null;

    }
}
