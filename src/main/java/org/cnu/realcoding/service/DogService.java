package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< Updated upstream
=======
import org.cnu.realcoding.Exception.DogNotFoundException;
>>>>>>> Stashed changes

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {
        dogRepository.insertDog(dog);
    }


    public Dog getDogByThreeParams(String name, String ownername, String ownerphonenumber)
    {
<<<<<<< Updated upstream
     Dog foundDog = dogRepository.getDogByThreeParams(name, ownername, ownerphonenumber);

       if(foundDog == null)
        throw new org.cnu.realcoding.Exception.DogNotFoundException();
       else
           return foundDog;
    }




=======
        Dog foundDog = dogRepository.getDogByThreeParams(name, ownername, ownerphonenumber);

        if(foundDog == null)
            throw new org.cnu.realcoding.Exception.DogNotFoundException();
        else
            return foundDog;
    }


>>>>>>> Stashed changes
}
