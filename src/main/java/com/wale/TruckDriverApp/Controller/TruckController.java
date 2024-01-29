package com.wale.TruckDriverApp.Controller;

import com.wale.TruckDriverApp.Entity.Trucks;
import com.wale.TruckDriverApp.Exceptions.TruckNotFoundException;
import com.wale.TruckDriverApp.Service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {
    @Autowired
    private TruckService truckService;

    @GetMapping("/welcome")
    public String welcome(){
        return "<html><body>"
                + "<h1>WELCOME</h1>"
                + "</body>THIS IS A TRUCK DRIVER WEB PAGE</html>";
    }

    @GetMapping("/getAllTruck")
    public List<Trucks> getAllTruck(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return truckService.getAllTrucks(pageNumber, pageSize);
    }
    @GetMapping("/{asset}")
    public Optional<Trucks> getTruckByAsset(@PathVariable String asset){
        Optional<Trucks> trucks = truckService.findByAsset(asset);
        if (trucks == null){
            throw new TruckNotFoundException("Truck with Id: " + asset + " not found");
        }
        return trucks;
    }


    @GetMapping("/getAllTrucks")
    public CompletableFuture<List<Trucks>> getAllTruck(){
        return truckService.getAllTrucks();
    }

}
