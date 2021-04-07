package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 스프링에 객체 생성 위임.
public class DogController {

    @Autowired
    private DogManagementService dogManagementService;

    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDogs(@RequestBody Dog dog) {
        dogManagementService.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogManagementService.getAllDogs();
    }

    // localhost:8014/dogs/ian
    @GetMapping("/dogs/{name}")
    public Dog getDogsByName(@PathVariable  String name){
        return dogManagementService.getDogByName(name);
    }

    @GetMapping("/dogs/,{ownerName}")
    public Dog getDogsByOwnerName(@PathVariable  String ownerName){
        return dogManagementService.getDogByOwnerName(ownerName);
    }


    @GetMapping("/dogs/,,{ownerPhoneNumber}")
    public Dog getDogByOwnerPhoneNumber(@PathVariable String ownerPhoneNumber){
        return dogManagementService.getDogByOwnerPhoneNumber(ownerPhoneNumber);
    }


    @GetMapping("/dogs/{name}/{ownerName}/{ownerPhoneNumber}")
    public Dog getDogByAll(@PathVariable String name,String ownerName, String ownerPhoneNumber ){
        return dogManagementService.getDogByAll(name,ownerName,ownerPhoneNumber);
    }


}
