package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/dogs")
    public void createDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }



    @GetMapping("/dogs/all/{name}/{ownername}/{ownerphonenumber}")
   // public Dog getDogByThreeParams(@RequestParam(value="name") String name, @RequestParam(value="ownername")String ownername, @RequestParam(value="ownerphonenumber") String ownerphonenumber)
    public Dog getDogByThreeParams( @PathVariable("name")String name, @PathVariable("ownername")String ownername,  @PathVariable("ownerphonenumber")String ownerphonenumber)
    {
        return dogService.getDogByThreeParams(name, ownername, ownerphonenumber); // service에서 작동
    }


    //세 가지 파라미터 모두 받기


}

// api > controller > service > repository