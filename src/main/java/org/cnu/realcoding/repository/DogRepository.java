package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
    }

    public Dog findDogByName(String name) {
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("name").is(name)),
                        Dog.class
                );
    }


    public List<Dog> findAllDog() {
        return mongoTemplate.findAll(Dog.class);
    }
}
