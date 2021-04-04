package org.cnu.realcoding.service;


import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogForbiddenException;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {
        dogRepository.insertDog(dog);
    }
    public Dog getDogName(String name){
        Dog dog = dogRepository.getDogName(name);
        if(dog == null){
            throw new DogNotFoundException();
        }
        return dog;
    }

    public Dog modifyWithAll(String name, Dog modDog) {
        Dog dog = dogRepository.getDogName(name);
        if(dog == null){
            throw new DogNotFoundException();
        }
        if(dogRepository.modifyWithAll(dog, modDog) == null) {
            throw new DogForbiddenException();
        }
        return dog;
    }
}
