package com.driver.api.controller;

import com.driver.api.dto.CabFareDTO;
import com.driver.api.model.CabFares;
import com.driver.api.service.CabFaresService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/fareAPI")
public class FareManager {
    @Autowired
    CabFaresService cabFaresService;

    @GetMapping("/cabFares")
    String getCabFare(Model model){
        List<CabFares> fareList = cabFaresService.getCabFare();
        model.addAttribute("fareList",fareList);
        return "CabFares";
    }
    @GetMapping("/cabFare/{id}")
    Integer getCabFare(@PathVariable int id){
        return cabFaresService.getCabFare(id);
    }
    @GetMapping("/cabFare")
    Integer getCabFare(@RequestParam String from,@RequestParam String to){
        return cabFaresService.getCabFare(from,to);
    }

    @GetMapping("/addFare")
    String addCabFare(){
        return "AddFares";
    }
    @PostMapping(value="/addFare")
    String addCabFare(CabFares cabFares){
        cabFaresService.addCabFare(cabFares);
        return "redirect:/fareAPI/cabFares";
    }
    @PutMapping("/updateFare/{id}")
    String updateFare(@PathVariable int id,@RequestBody CabFareDTO cabFareDTO){
        return cabFaresService.updateFare(id,cabFareDTO.getFare());
    }
    @DeleteMapping("/deleteFare/{id}")
    String deleteFare(@PathVariable int id){
        return cabFaresService.deleteFare(id);
    }
}
