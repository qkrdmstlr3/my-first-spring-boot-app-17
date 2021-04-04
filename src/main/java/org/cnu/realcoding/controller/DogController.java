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

    @GetMapping("/dogs/ownerName/{ownerName}")
    public Dog getDogByOwnerName(@PathVariable String ownerName) {
        return dogService.getDogByOwnerName(ownerName);
    }

    @PatchMapping("/dogs/kind/name/{name}")
    public void modifyDogKind(@PathVariable String name, @RequestBody Dog dog) {
        dogService.modifyDogKind(name, dog.getKind());
    }
}

// api > controller > service > repository