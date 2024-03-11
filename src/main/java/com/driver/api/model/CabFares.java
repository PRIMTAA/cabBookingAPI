package com.driver.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabFares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String start;
    private String end;
    private int fare;
}
