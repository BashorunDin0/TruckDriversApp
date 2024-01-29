package com.wale.TruckDriverApp.Service;

import com.wale.TruckDriverApp.Entity.Trucks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


public interface TruckService {

    public CompletableFuture<List<Trucks>> getAllTrucks();
    Optional<Trucks> findByAsset(String asset);
    List<Trucks> getAllTrucks(int pageNumber, int pageSize);


}
