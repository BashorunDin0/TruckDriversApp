package com.wale.TruckDriverApp.Service;

import com.wale.TruckDriverApp.Entity.Trucks;
import com.wale.TruckDriverApp.Repository.TruckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckRepo truckRepo;

    @Async
    @Override
    public CompletableFuture<List<Trucks>> getAllTrucks() {
        List<Trucks> trucks = truckRepo.findAll();
        return CompletableFuture.completedFuture(trucks);
    }
    @Override
    public List<Trucks> getAllTrucks(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize);
        return truckRepo.findAll(pages).getContent();
    }

    @Override
    public Optional<Trucks> findByAsset(String asset) {
        return truckRepo.findByAsset(asset);
    }
}
