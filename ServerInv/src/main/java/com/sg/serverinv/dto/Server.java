/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.serverinv.dto;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Lizz
 */
public class Server {
    private String name;
    private String ip;
    private String manufacturer;
    private int ram;
    private int numProcessors;
    private LocalDate purchaseDate;
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getNumProcessors() {
        return numProcessors;
    }

    public void setNumProcessors(int numProcessors) {
        this.numProcessors = numProcessors;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    //property that is calc based on member - purchase date
    
    public long getServerAge() {
        Period p = purchaseDate.until(LocalDate.now());
        return p.getYears();
    }
    
    
    
}
