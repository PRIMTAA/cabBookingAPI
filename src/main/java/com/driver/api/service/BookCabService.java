package com.driver.api.service;

import com.driver.api.model.BookCab;

import java.util.List;

public interface BookCabService {
    public List<BookCab> getBooking();
    public String createBooking(BookCab bookCab);
    public String updateBooking(BookCab bookCab);
    public String deleteBooking(int id);
}
