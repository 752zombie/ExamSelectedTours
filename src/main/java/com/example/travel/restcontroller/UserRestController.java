package com.example.travel.restcontroller;

import com.example.travel.model.User;
import com.example.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepository;


    @PostMapping(value = "api/createUser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User newUser) throws Exception {
        User user = userRepository.save(newUser);

        if (user == null) {
            throw new Exception();
        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }



    @PostMapping(value ="api/user_login", consumes = "application/json")
    public Boolean userLogin(@RequestBody User user) {
        Optional<User> newUser = userRepository.findByFirstNameAndPassword(user.getFirstName(), user.getPassword());
        newUser.ifPresent(value -> System.out.println(value.getEmail()));
        if (newUser.isPresent()){
            return true;
        }
        else return false;
    }

}
