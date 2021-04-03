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
}
