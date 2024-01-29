package com.wale.TruckDriverApp.Repository;

import com.wale.TruckDriverApp.Entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DriverRepo extends JpaRepository<Drivers, Long> {
    Optional<Drivers> findByEmployee(Long employee);
}
