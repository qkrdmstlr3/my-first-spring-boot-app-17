package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cnu.realcoding.exception.DogNotFoundException;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {

        dogRepository.insertDog(dog);
    }

    public Dog getDogByOwnerName(String ownerName) {
        Dog dog = dogRepository.getDogByOwnerName(ownerName);
        if(dog == null) {
            throw new DogNotFoundException("HTTP STATUS : 404");
        }
        return dog;
    }

}
