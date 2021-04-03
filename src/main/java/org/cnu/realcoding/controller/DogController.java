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
    @PostMapping("/dog")
    public void createDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }

    /* 조회 */
    @GetMapping("/dog/ownerPhoneNumber/{ownerPhoneNumber}")
    public Dog getDogByOwnerPhoneNumber(@PathVariable String ownerPhoneNumber) {
        return dogService.getDogByOwnerPhoneNumber(ownerPhoneNumber);
    }

    /* 수정 */
}

// api > controller > service > repository