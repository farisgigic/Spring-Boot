package com.example.demo.library.core.repository;

import com.example.demo.library.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query(value = "{'_id' :  ?0}", fields = "{'id': 1, 'firstName' :  1, 'lastName': 1, 'email': 1}")
    List<User> findAllUsers(); // it needs to be List since it returns more than 1 user

    @Query(value = "{ 'email' : ?0}", fields = "{'id': 1, 'firstName' :  1, 'lastName' :  1, 'email' : 1, 'userType' :  1}")
    Optional<User> findByEmailCustom(String email); // Optional<User> is used when you want to retrieve single user


    @Query(value="{$or:[{email:'?0'}, {username:'?0'}]}")
    Optional<User> findByUsernameOrEmail(String username);
}
