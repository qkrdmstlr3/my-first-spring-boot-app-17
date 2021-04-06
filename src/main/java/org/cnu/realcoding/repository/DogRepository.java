package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository
{
    @Autowired
    private MongoTemplate mongoTemplate;



    public void insertDog(Dog dog)
    {
        mongoTemplate.insert(dog);

    }


    public Dog getDogByThreeParams(String name, String ownername, String ownerphonenumber)
    {
       //return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), Dog.class);


        if((mongoTemplate.findOne(Query.query(  Criteria.where("name").is(name)  ), Dog.class) !=null))
            if((mongoTemplate.findOne(Query.query(  Criteria.where("ownerName").is(ownername)  ), Dog.class) !=null) )
                if((mongoTemplate.findOne(Query.query(  Criteria.where("ownerPhoneNumber").is(ownerphonenumber)  ), Dog.class) !=null))
                 return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), Dog.class);



        return null;
    }



}
