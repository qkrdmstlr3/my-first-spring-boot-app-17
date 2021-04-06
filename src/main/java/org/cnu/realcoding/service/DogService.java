package org.cnu.realcoding.service;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogConflictException;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    /* 삽입 */
    public void insertDog(Dog dog) {
        Boolean isInserted = dogRepository.insertDog(dog);
        if(!isInserted) {
            throw new DogConflictException();
        }
    }

    /* 조회 */
    public List<Dog> getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        List<Dog> dogs = dogRepository.getDogByOwnerPhoneNumber(ownerPhoneNumber);
        if(dogs == null) {
            throw new DogNotFoundException();
        }
        return dogs;
    }

    /* 수정 */
    public Dog modifyWithAddingDogRecord(
            String name,
            String ownerName,
            String ownerPhoneNumber,
            List<String> newRecords
    ) {
        Dog dog = dogRepository.modifyWithAddingDogRecord(name, ownerName, ownerPhoneNumber, newRecords);
        if(dog == null) {
            throw new DogNotFoundException();
        }
        return dog;
    }
}
