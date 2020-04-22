package com.sergio.restapi.Controller;


import com.sergio.restapi.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok("register");
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok("Login");
    }


}
