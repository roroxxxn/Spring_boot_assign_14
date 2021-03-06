package org.cnu.realcoding.service;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogsConflicException;
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

        //name,ownerName,ownerPhoneNumber ์กฐํํ๋ f
        Dog dogf = dogRepository.findDogByAll(dog.getName(),dog.getOwnerName(),dog.getOwnerPhoneNumber());

        if(dogf != null){ //dogf != null
            throw new DogsConflicException();
        }
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

    public void updateDogkind(String name, String ownerName, String ownerPhoneNumber, String kind){
        Dog dog = dogRepository.findDogByAll(name,ownerName,ownerPhoneNumber);
            dog.setKind(kind);
        if(dog==null){
            throw new DogsNotFoundException();
        }
        dogRepository.updateDogkind(dog);
    }

}
