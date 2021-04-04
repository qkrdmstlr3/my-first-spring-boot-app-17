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
    @GetMapping("/dogs/name/{name}")
    public Dog getDogName(@PathVariable String name) {
        return dogService.getDogName(name);
    }
    @PatchMapping("/dogs/all/name/{name}")
    public Dog modifyWithAll(@PathVariable String name, @RequestBody Dog dog) {
        return dogService.modifyWithAll(name, dog);
    }

}

// api > controller > service > repository