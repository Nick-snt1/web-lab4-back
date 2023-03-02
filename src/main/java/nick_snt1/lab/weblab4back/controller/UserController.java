package nick_snt1.lab.weblab4back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nick_snt1.lab.weblab4back.dto.*;
import nick_snt1.lab.weblab4back.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserController {
    
    @Autowired private UserService service;
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated @RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(service.register(userDTO));
        } catch (Exception e) { 
            return ResponseEntity.badRequest().body("Name " + userDTO.getName() + " has already taken." + e.getMessage() +" "+ e.getCause());
        }
        
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@Validated @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(service.authenticate(userDTO));
    }


    
}
