package com.wale.TruckDriverApp.Service;

import com.wale.TruckDriverApp.Entity.LoginResponseDTO;
import com.wale.TruckDriverApp.Entity.Role;
import com.wale.TruckDriverApp.Entity.User;
import com.wale.TruckDriverApp.Repository.RoleRepository;
import com.wale.TruckDriverApp.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    public User registerUser(String email, String password, String username, String dob, String state, String country){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new User(email, encodedPassword, username, dob, state, country, authorities));
    }

    public LoginResponseDTO loginUser(String email, String password){
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepository.findByEmail(email).get(), token);
        } catch (AuthenticationException e){
            return new LoginResponseDTO(null, "");
        }

    }
}
