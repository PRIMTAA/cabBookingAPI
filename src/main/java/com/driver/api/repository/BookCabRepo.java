package com.driver.api.repository;

import com.driver.api.model.BookCab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCabRepo extends JpaRepository<BookCab,Integer> {
}