package org.cnu.realcoding.service;


import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogForbiddenException;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {
        dogRepository.insertDog(dog);
    }
    public List<Dog> getDogByDogName(String name){
        List <Dog> dog = dogRepository.getDogByDogName(name);
        if(dog == null){
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
