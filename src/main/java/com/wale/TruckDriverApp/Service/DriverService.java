package com.wale.TruckDriverApp.Service;

import com.wale.TruckDriverApp.Entity.Drivers;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface DriverService {
    public CompletableFuture<List<Drivers>> getAllDriver();
   public Optional<Drivers> findByEmployee(Long employee);
   List<Drivers> getAllDriver(int pageNumber, int pageSize);
}
