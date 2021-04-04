package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    /* 삽입 */
    @PostMapping("/dogs")
    public void createDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }

    /* 조회 */
    @GetMapping("/dogs/ownerPhoneNumber/{ownerPhoneNumber}")
    public Dog getDogByOwnerPhoneNumber(@PathVariable String ownerPhoneNumber) {
        return dogService.getDogByOwnerPhoneNumber(ownerPhoneNumber);
    }

    /* 수정 */
    @PatchMapping("/dogs/records/name/{name}")
    public Dog modifyWithAddingDogRecord(@PathVariable String name, @RequestBody Dog dog) {
        return dogService.modifyWithAddingDogRecord(name, dog.getMedicalRecords());
    }
}

// api > controller > service > repository