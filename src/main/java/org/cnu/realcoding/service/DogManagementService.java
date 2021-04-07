package org.cnu.realcoding.service;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cnu.realcoding.repository.DogRepository;

import java.util.List;

@Service
public class DogManagementService {
   @Autowired
    private DogRepository dogRepository;


    public void insertDog(Dog dog) {
        dogRepository.insertDog(dog);
    }

    public List<Dog> getAllDogs(){
        return dogRepository.findAllDog();
    }

    public Dog getDogByName(String name) {
        Dog dog =  dogRepository.findDogByName(name);
        if(dog == null){
            throw  new DogsNotFoundException();
        }
        return dog;
    }

    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber){
        Dog dog=dogRepository.findDogByOwnerPhoneNumber(ownerPhoneNumber);

        if(dog==null){
            throw new DogsNotFoundException();
        }
        return dog;
    }


    public Dog getDogByOwnerName(String ownerName) {
        Dog dog = dogRepository.findDogByOwnerName(ownerName);

        if(dog == null){
            throw new DogsNotFoundException();
        }

        return dog;
    }




    public Dog getDogByAll(String name, String ownerName, String ownerPhoneNumber) {
        Dog dog=dogRepository.findDogByAll(name,ownerName,ownerPhoneNumber);

        if(dog==null){
            throw new DogsNotFoundException();
        }
        return dog;
    }

}
