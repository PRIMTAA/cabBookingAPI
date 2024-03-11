package com.driver.api.repository;

import com.driver.api.model.CabFares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CabFaresRepo extends JpaRepository<CabFares,Integer> {
    @Query("SELECT c.fare FROM CabFares c WHERE c.start = :from AND c.end = :to")
    int getCabFare(@Param("from") String from, @Param("to") String to);

    boolean existsByStartAndEnd(String start, String end);

    @Query("SELECT c.start from CabFares c")
    List<String> allStarts();

    @Query("SELECT c.end from CabFares c")
    List<String> allends();
}
