package com.wale.TruckDriverApp.Repository;

import com.wale.TruckDriverApp.Entity.RegistrationDTO;
import com.wale.TruckDriverApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
