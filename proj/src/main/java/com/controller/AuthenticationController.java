package com.controller;

import com.dao.LoginRequest;
import com.dao.LoginResponse;
import com.model.Client;
import com.model.Credential;
import com.model.User;
import com.model.WarehouseAdmin;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginRequest credentials){
        try{
            Credential testUser = new Credential(credentials.getUsername(), credentials.getPassword());
            User userFromDb = userRepository.findLogin(testUser.getUsername(), testUser.getPassword());
            Credential credentialUserFromDb = new Credential(userFromDb.getUsername(), userFromDb.getPassword());
            if(testUser.equals(credentialUserFromDb)){
                LoginResponse loginResponse = new LoginResponse(userFromDb.getId(), userFromDb.getRole());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginResponse);
            }
            else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username or password incorrect");
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody LoginRequest loginRequest){
        try{
            Credential testUser = new Credential(loginRequest.getUsername(), loginRequest.getPassword());
            User userFromDb = userRepository.findLogin(testUser.getUsername(), testUser.getPassword());
            Credential credentialUserFromDb = new Credential(userFromDb.getUsername(), userFromDb.getPassword());
            if(testUser.equals(credentialUserFromDb)){
                return new ResponseEntity<>("User already exists!", HttpStatus.CONFLICT);
            }
            else{
                if(Objects.equals(loginRequest.getRole(), "CLIENT")){
                    User newUser = new Client(loginRequest.getUsername(), loginRequest.getPassword(), loginRequest.getUsername() + "@gmail.com");
                    userRepository.add(newUser);
                    return new ResponseEntity<>("User registered!", HttpStatus.OK);
                }
                else{
                    User newUser = new WarehouseAdmin(loginRequest.getUsername(), loginRequest.getPassword(), loginRequest.getUsername() + "@gmail.com");
                    userRepository.add(newUser);
                    return new ResponseEntity<>("User registered!", HttpStatus.OK);
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }
}
