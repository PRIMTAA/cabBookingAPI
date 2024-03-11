package com.driver.api.service.impl;

import com.driver.api.model.CabFares;
import com.driver.api.repository.CabFaresRepo;
import com.driver.api.service.CabFaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class CabFaresImpl implements CabFaresService {

    @Autowired
    CabFaresRepo cabFaresRepo;

    @Override
    public List<CabFares> getCabFare() {
        return cabFaresRepo.findAll();
    }

    @Override
    public int getCabFare(int id) {
        if (cabFaresRepo.existsById(id)) {
            return cabFaresRepo.findById(id).get().getFare();
        }
        return -1;
    }

    @Override
    public int getCabFare(String from, String to) {
      if(cabFaresRepo.existsByStartAndEnd(from,to)){
            return cabFaresRepo.getCabFare(from,to);
        }
        return -1;
    }

    @Override
    public CabFares addCabFare(@ModelAttribute CabFares cabFares) {
        cabFaresRepo.save(cabFares);
        return cabFares;
    }

    @Override
    public String updateFare(int id,int amount) {
        if(cabFaresRepo.existsById(id)){
            CabFares c = cabFaresRepo.findById(id).get();
            c.setFare(amount);
            cabFaresRepo.save(c);
            return ("Fare for the route updated");
        }
        return "invalid id";
    }

    @Override
    public String deleteFare(int id) {
        if(cabFaresRepo.existsById(id)){
            cabFaresRepo.deleteById(id);
            return("Fare details deleted");
        }
        return "provided ID does not exist";
    }
}
