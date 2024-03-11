package com.driver.api.service.impl;

import com.driver.api.model.Vehicles;
import com.driver.api.repository.VehiclesRepo;
import com.driver.api.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesImpl implements VehiclesService {
    @Autowired
    VehiclesRepo vehiclesRepo;
    @Override
    public Vehicles getVehicleDetails(int id) {
        if(vehiclesRepo.existsById(id)){
            return vehiclesRepo.findById(id).get();
        }
        return null;
    }

    @Override
    public List<Vehicles> getAllVehicles() {
        return vehiclesRepo.findAll();
    }

    @Override
    public void addVehicle(Vehicles vehicles) {
        vehiclesRepo.save(vehicles);
    }

    @Override
    public String updateVehicle(Vehicles vehicles) {
        if(vehiclesRepo.existsById(vehicles.getVId())){
            vehiclesRepo.save(vehicles);
            return "vehicle details updated";
        }
        return "Vehicle not found";
    }

    @Override
    public void deleteVehicle() {
        vehiclesRepo.deleteAll();
    }

    @Override
    public String deleteVehicle(int id) {
        if(vehiclesRepo.existsById(id)){
            vehiclesRepo.deleteById(id);
            return "vehicle details removed";
        }
        return "vehicle does not exist";
    }
}
