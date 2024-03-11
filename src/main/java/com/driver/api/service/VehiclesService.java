package com.driver.api.service;

import com.driver.api.model.Vehicles;

import java.util.List;

public interface VehiclesService {
    Vehicles getVehicleDetails(int id);
    List<Vehicles> getAllVehicles();
    void addVehicle(Vehicles vehicles);
    String updateVehicle(Vehicles vehicles);
    void deleteVehicle();
    String deleteVehicle(int id);
}
