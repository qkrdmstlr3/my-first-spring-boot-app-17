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
    @PostMapping("/dogs")
    public void createDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }


<<<<<<< Updated upstream
    @GetMapping("/dog/Threeparam/{threeparam}")
    public Dog getDogByThreeParams(@PathVariable String name, String ownername, String ownerphonenumber)
=======
    @GetMapping("/dogs")
    public Dog getDogByThreeParams(@RequestParam(value="name") String name, @RequestParam(value="ownername")String ownername, @RequestParam(value="ownerphonenumber") String ownerphonenumber)
>>>>>>> Stashed changes
    {
        return dogService.getDogByThreeParams(name, ownername, ownerphonenumber); // service에서 작동
    }

<<<<<<< Updated upstream
    //세 가지 파라미터 모두 받기
=======
>>>>>>> Stashed changes

}

// api > controller > service > repository