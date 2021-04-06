package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/dog")
    public void createDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }

    @GetMapping("/dogs/ownerName/{ownerName}")
    public List<Dog> getDogByOwnerName(@PathVariable String ownerName) {
        return dogService.getDogByOwnerName(ownerName);
    }

    @PatchMapping("/dogs/records/name/{name}/ownerName/{ownerName}/ownerPhoneNumber/{ownerPhoneNumber}")
    public Dog modifyDogKind( @PathVariable String name,@PathVariable String ownerName,@PathVariable String ownerPhoneNumber,@RequestBody Dog dog) {
        return dogService.modifyDogKind(name, ownerName, ownerPhoneNumber, dog.getKind());
    }
}

// api > controller > service > repository