package com.wale.TruckDriverApp.Controller;

import com.wale.TruckDriverApp.Entity.LoginResponseDTO;
import com.wale.TruckDriverApp.Entity.RegistrationDTO;
import com.wale.TruckDriverApp.Entity.User;
import com.wale.TruckDriverApp.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getEmail(),
                body.getPassword(), body.getUsername(),
                body.getDob(), body.getState(), body.getCountry());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getEmail(), body.getPassword());
    }
}
