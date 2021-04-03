package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {
    private List<Dog> dogs = new ArrayList<>();

    public void insertDog(Dog dog) {
        dogs.add(dog);
    }

    public Dog getDogByOwnerName(String ownerName) {
        for(Dog dog: dogs) {
            if(dog.getOwnerName().equals(ownerName)) {
                return dog;
            }
        }
        return null;
    }
}
