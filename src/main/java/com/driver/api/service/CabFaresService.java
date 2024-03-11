package com.driver.api.service;

import com.driver.api.model.CabFares;

import java.util.List;

public interface CabFaresService {
    public List<CabFares> getCabFare();
    public int getCabFare(int id);
    public int getCabFare(String from,String to);
    public CabFares addCabFare(CabFares cabFares);
    public String updateFare(int id,int amount);
    public String deleteFare(int id);

}
