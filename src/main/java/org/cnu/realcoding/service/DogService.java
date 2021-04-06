package org.cnu.realcoding.service;


import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogConflictException;
import org.cnu.realcoding.exception.DogForbiddenException;
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
        boolean isInserted = dogRepository.insertDog(dog);
        if(!isInserted) {
            throw new DogConflictException();
        }
    }

    /* 조회 */
    public List<Dog> getDogByOwnerName(String ownerName) {
        List<Dog> dogs = dogRepository.getDogByOwnerName(ownerName);
        if(dogs.size() == 0) {
            throw new DogNotFoundException("HTTP STATUS : 404");
        }
        return dogs;
    }
    public List<Dog> getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        List<Dog> dogs = dogRepository.getDogByOwnerPhoneNumber(ownerPhoneNumber);
        if(dogs.size() == 0) {
            throw new DogNotFoundException();
        }
        return dogs;
    }
    public List<Dog> getDogByDogName(String name){
        List <Dog> dog = dogRepository.getDogByDogName(name);
        if(dog.size() == 0){
            throw new DogNotFoundException();
        }
        return dog;
    }

    public Dog getDogByThreeParams(String name, String ownername, String ownerphonenumber) {

        Dog foundDog = dogRepository.getDogByThreeParams(name, ownername, ownerphonenumber);

        if (foundDog == null)
            throw new org.cnu.realcoding.exception.DogNotFoundException();
        else
            return foundDog;
    }

    /* 수정 */
    public Dog modifyDogKind(String name, String ownerName, String ownerPhoneNumber, String kind) {
        Dog tmpDog = dogRepository.modifyDogKind(name, ownerName, ownerPhoneNumber, kind);
        if(tmpDog == null)
        {
            throw new DogNotFoundException("HTTP STATUS : 404");
        }
        else
        {
            return tmpDog;
        }
    }
  
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

    public Dog modifyWithAll(String[] oldDog, Dog modifyDog) {
        String name = oldDog[0];
        String ownerName = oldDog[1];
        String ownerPhoneNumber = oldDog[2];
        Dog dog = dogRepository.getDogByThreeParams(name, ownerName, ownerPhoneNumber);
        if(dog == null){
            throw new DogNotFoundException();
        }
        if(dogRepository.modifyWithAll(dog, modifyDog) == null) {
            throw new DogForbiddenException();
        }
        return dog;
    }

}





