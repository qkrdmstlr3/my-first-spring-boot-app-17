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

    /* 삽입 */
    @PostMapping("/dogs")
    public void createDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }
  
    /* 조회 */
    @GetMapping("/dogs/ownerPhoneNumber/{ownerPhoneNumber}")
    public List<Dog> getDogByOwnerPhoneNumber(@PathVariable String ownerPhoneNumber) {
        return dogService.getDogByOwnerPhoneNumber(ownerPhoneNumber);
    }

    @GetMapping("/dogs/ownerName/{ownerName}")
    public List<Dog> getDogByOwnerName(@PathVariable String ownerName) {
        return dogService.getDogByOwnerName(ownerName);
    }

    /* 수정 */
    @PatchMapping("/dogs/records/name/{name}/ownerName/{ownerName}/ownerPhoneNumber/{ownerPhoneNumber}")
    public Dog modifyDogKind( @PathVariable String name,@PathVariable String ownerName,@PathVariable String ownerPhoneNumber,@RequestBody Dog dog) {
        return dogService.modifyDogKind(name, ownerName, ownerPhoneNumber, dog.getKind());
  
    @PatchMapping("/dogs/records/name/{name}/ownerName/{ownerName}/ownerPhoneNumber/{ownerPhoneNumber}")
    public Dog modifyWithAddingDogRecord(
            @PathVariable String name,
            @PathVariable String ownerName,
            @PathVariable String ownerPhoneNumber,
            @RequestBody Dog dog
    ) {
        return dogService.modifyWithAddingDogRecord(name, ownerName, ownerPhoneNumber, dog.getMedicalRecords());
    }
}

// api > controller > service > repository