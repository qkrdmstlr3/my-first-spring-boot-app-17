package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/dog")
    public void createDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }

    @GetMapping("/dog/ownerName/{ownerName}")
    public Dog getDogByOwnerName(@PathVariable String ownerName) {
        return dogService.getDogByOwnerName(ownerName);
    }

}

// api > controller > service > repository