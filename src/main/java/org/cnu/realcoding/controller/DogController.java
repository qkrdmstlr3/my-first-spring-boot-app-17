package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/dogs")
    public void createDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }
    @GetMapping("/dogs/name/{name}")
    public List<Dog> getDogByDogName(@PathVariable String name) {
        return dogService.getDogByDogName(name);
    }
    @PatchMapping("/dogs/all/name/{name}/ownerName/{ownerName}/ownerPhoneNumber/{ownerPhoneNumber}")
    public Dog modifyWithAll(@PathVariable String name,
            @PathVariable String ownerName,
            @PathVariable String ownerPhoneNumber,
            @RequestBody Dog dog) {
        String[] oldDog = new String[3];
        oldDog[0] = name;
        oldDog[1] = ownerName;
        oldDog[2] = ownerPhoneNumber;

        return dogService.modifyWithAll(oldDog, dog);
    }

}

// api > controller > service > repository