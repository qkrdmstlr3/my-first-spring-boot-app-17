package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exeption.DogNotFoundException;
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
        dogRepository.insertDog(dog);
    }

    /* 조회 */
    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        Dog dog = dogRepository.getDogByOwnerPhoneNumber(ownerPhoneNumber);
        if(dog == null) {
            throw new DogNotFoundException();
        }
        return dog;
    }

    /* 수정 */
    public Dog modifyWithAddingDogRecord(String name, List<String> newRecords) {
        Dog dog = dogRepository.modifyWithAddingDogRecord(name, newRecords);
        if(dog == null) {
            throw new DogNotFoundException();
        }
        return dog;
    }
}
