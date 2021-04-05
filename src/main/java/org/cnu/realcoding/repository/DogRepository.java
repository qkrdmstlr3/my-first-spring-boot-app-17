package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {
    private List<Dog> dogs = new ArrayList<>();

    public void insertDog(Dog dog)
    {
        dogs.add(dog);
    }

<<<<<<< Updated upstream
    public Dog getDogByThreeParams(String name, String ownername, String ownerphonenumber)
    {

        for(Dog dog : dogs )
            if(dog.getName().equals(name))
            {
                if(dog.getOwnerName().equals(ownername))
                {
                     if(dog.getOwnerPhoneNumber().equals(ownerphonenumber))
                        return dog;
                }

=======

    public Dog getDogByThreeParams(String name, String ownername, String ownerphonenumber)
    {

        for(Dog dog : dogs )
            if(dog.getName().equals(name))
            {
                if(dog.getOwnerName().equals(ownername))
                {
                    if(dog.getOwnerPhoneNumber().equals(ownerphonenumber))
                        return dog;
                }

>>>>>>> Stashed changes
            }
        return null;


    }



}
