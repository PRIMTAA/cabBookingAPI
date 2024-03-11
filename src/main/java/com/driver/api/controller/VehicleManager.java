package com.driver.api.controller;

import com.driver.api.model.Vehicles;
import com.driver.api.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicleAPI")
public class VehicleManager {
    @Autowired
    VehiclesService vehiclesService;

    @GetMapping("/all")
    String getAllVehicles(Model model) {
        List<Vehicles> vehicleList = vehiclesService.getAllVehicles();
                model.addAttribute("vehicleList", vehicleList);
                return "Vehicles";
    }

    @GetMapping("/{id}")
    Vehicles getVehicleDetails(@PathVariable int id) {
        return vehiclesService.getVehicleDetails(id);
    }

    @GetMapping("/addVehicle")
    String addNewVehicle(){
        return "AddVehicle";
    }

    @PostMapping("/addVehicle")
    String addNewVehicle(@ModelAttribute Vehicles vehicles) {
        System.out.println(vehicles.toString());
        vehiclesService.addVehicle(vehicles);
        return "redirect:/vehicleAPI/all";
    }

    @PutMapping("/updateVehicle")
    String updateVehicle(@RequestBody Vehicles vehicles) {
        return vehiclesService.updateVehicle(vehicles);
    }

    @DeleteMapping("/deleteVehicle/{id}")
    String deleteVehicle(@PathVariable int id) {
       return vehiclesService.deleteVehicle(id);
    }

    @DeleteMapping("/deleteVehicle")
    String deleteVehicle() {
        vehiclesService.deleteVehicle();
        return "all vehicles data removed";
    }

}