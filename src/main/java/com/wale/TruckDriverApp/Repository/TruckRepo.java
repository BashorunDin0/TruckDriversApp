package com.wale.TruckDriverApp.Repository;

import com.wale.TruckDriverApp.Entity.Trucks;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TruckRepo extends JpaRepository<Trucks, Long> {
    Optional<Trucks> findByAsset(String asset);
}
