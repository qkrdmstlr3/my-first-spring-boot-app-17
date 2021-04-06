package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.cnu.realcoding.exception.DogConflictException;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {

        boolean isInserted = dogRepository.insertDog(dog);
        if(isInserted==false) {
            throw new DogConflictException();
        }
    }

    public List<Dog> getDogByOwnerName(String ownerName) {
        List<Dog> dogs = dogRepository.getDogByOwnerName(ownerName);
        if(dogs == null) {
            throw new DogNotFoundException("HTTP STATUS : 404");
        }
        return dogs;
    }

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
}
