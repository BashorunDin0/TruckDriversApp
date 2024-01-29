package com.wale.TruckDriverApp.Controller;

import com.wale.TruckDriverApp.Entity.Drivers;
import com.wale.TruckDriverApp.Exceptions.DriverNotFoundException;
import com.wale.TruckDriverApp.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/getAllDriver")
    public List<Drivers> getAllDrivers(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {

        return driverService.getAllDriver(pageNumber, pageSize);
    }
    @GetMapping("/{employee}")
    public Optional<Drivers> getDiverByEmployee(@PathVariable Long employee){
        Optional<Drivers> drivers = driverService.findByEmployee(employee);
        if (drivers == null){
            throw new DriverNotFoundException("Driver with id: " + employee + " not found");
        } return drivers;
    }


    @GetMapping("/getAllDrivers")
    public CompletableFuture<List<Drivers>> getAllDrivers() {
        return driverService.getAllDriver();

    }
}
