package com.example.travel.restcontroller;

import com.example.travel.model.User;
import com.example.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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



    @PostMapping(value ="api/userLogin", consumes = "application/json")
    public ResponseEntity<User> userLogin(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findByFirstNameAndPassword(user.getFirstName(), user.getPassword());
        if (userOptional.isPresent() ) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }else
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }




    @GetMapping("/api/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

}
