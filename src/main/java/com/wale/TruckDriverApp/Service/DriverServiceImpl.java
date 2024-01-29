package com.wale.TruckDriverApp.Service;

import com.wale.TruckDriverApp.Entity.Drivers;
import com.wale.TruckDriverApp.Repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;
    @Async
    @Override
    public CompletableFuture<List<Drivers>> getAllDriver() {
        List<Drivers> drivers = driverRepo.findAll();
        return CompletableFuture.completedFuture(drivers);
    }

    @Override
    public Optional <Drivers> findByEmployee(Long employee) {
        return driverRepo.findByEmployee(employee);
    }

    @Override
    public List<Drivers> getAllDriver(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize);
        return driverRepo.findAll(pages).getContent();
    }


}
