package com.driver.api.repository;

import com.driver.api.model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiclesRepo extends JpaRepository<Vehicles,Integer> {

    @Query("SELECT v.vechName FROM Vehicles v")
    List<String> findVechNames();
}
