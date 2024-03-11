package com.driver.api.controller;

import com.driver.api.model.BookCab;
import com.driver.api.model.CabFares;
import com.driver.api.model.Vehicles;
import com.driver.api.repository.BookCabRepo;
import com.driver.api.repository.CabFaresRepo;
import com.driver.api.repository.VehiclesRepo;
import com.driver.api.service.BookCabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookingAPI")
public class BookingManager {
    @Autowired
    BookCabService bookCabService;

    @Autowired
    CabFaresRepo cabFaresRepo;

    @Autowired
    VehiclesRepo vehiclesRepo;
    @Autowired
    BookCabRepo bookCabRepo;

    @GetMapping("/")
    public String getBooking(Model model) {

        List<String>vech = vehiclesRepo.findVechNames();
        List<String> from = cabFaresRepo.allStarts();
        List<String> to = cabFaresRepo.allends();
        model.addAttribute("from",from);
        model.addAttribute("to",to);
        model.addAttribute("vechNames",vech);
        return "BookCab";
    }

    @GetMapping("/createBooking")
    public String displayBookings(Model model){
        List<BookCab> bookingList = bookCabRepo.findAll();
        model.addAttribute("bookingList", bookingList);
        return "bookedCab";
    }
    @PostMapping("/createBooking")
    public String addBooking(@ModelAttribute BookCab bookCab){
        int fare = cabFaresRepo.getCabFare(bookCab.getStart(),bookCab.getEnd());
        bookCab.setFare(fare);
        bookCabService.createBooking(bookCab);
        return "redirect:/bookingAPI/createBooking";
    }
    @PutMapping("/updateBooking")
    public String updateBooking(@RequestBody BookCab bookCab){
        return bookCabService.updateBooking(bookCab);
    }
    @DeleteMapping("/{id}")
    public String removeBooking(@PathVariable int id) {
        return bookCabService.deleteBooking(id);
    }
}
