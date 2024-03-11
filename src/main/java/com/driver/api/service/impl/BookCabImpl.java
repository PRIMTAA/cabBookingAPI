package com.driver.api.service.impl;

import com.driver.api.model.BookCab;
import com.driver.api.repository.BookCabRepo;
import com.driver.api.service.BookCabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookCabImpl implements BookCabService {

    @Autowired
    BookCabRepo bookCabRepo;
    @Override
    public List<BookCab> getBooking() {
            return bookCabRepo.findAll();

    }

    @Override
    public String createBooking(BookCab bookCab) {
        bookCabRepo.save(bookCab);
        return ("new booking created");
    }

    @Override
    public String updateBooking(BookCab bookCab) {
        if(bookCabRepo.existsById(bookCab.getBookId())){
            bookCabRepo.save(bookCab);
            return ("booking details have been updated");
        }
      return "booking does not exist";
    }

    @Override
    public String deleteBooking(int id) {
        if(bookCabRepo.existsById(id)){
            bookCabRepo.deleteById(id);
            return("booking removed");
        }
        return "invalid id";

    }
}
