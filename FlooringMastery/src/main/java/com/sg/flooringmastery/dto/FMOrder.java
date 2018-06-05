/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Lizz
 */
public class FMOrder {

    private int orderNumber;
    private String customerName;
    private String state;
    private BigDecimal taxRate;
    private String materialType;
    private String stringArea;
    private BigDecimal area;
    private BigDecimal materialPerSqFt;
    private BigDecimal laborPerSqFt;
    private BigDecimal materialTotal;
    private BigDecimal laborTotal;
    private BigDecimal taxTotal;
    private BigDecimal total;

    public String getStringArea() {
        return stringArea;
    }

    public void setStringArea(String stringArea) {
        this.stringArea = stringArea;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialPerSqFt() {
        return materialPerSqFt;
    }

    public void setMaterialPerSqFt(BigDecimal materialPerSqFt) {
        this.materialPerSqFt = materialPerSqFt;
    }

    public BigDecimal getLaborPerSqFt() {
        return laborPerSqFt;
    }

    public void setLaborPerSqFt(BigDecimal laborPerSqFt) {
        this.laborPerSqFt = laborPerSqFt;
    }

    public BigDecimal getMaterialTotal() {
        return materialTotal;
    }

    public void setMaterialTotal(BigDecimal materialTotal) {
        this.materialTotal = materialTotal;
    }

    public BigDecimal getLaborTotal() {
        return laborTotal;
    }

    public void setLaborTotal(BigDecimal laborTotal) {
        this.laborTotal = laborTotal;
    }

    public BigDecimal getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(BigDecimal taxTotal) {
        this.taxTotal = taxTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.orderNumber);
        hash = 53 * hash + Objects.hashCode(this.customerName);
        hash = 53 * hash + Objects.hashCode(this.state);
        hash = 53 * hash + Objects.hashCode(this.taxRate);
        hash = 53 * hash + Objects.hashCode(this.materialType);
        hash = 53 * hash + Objects.hashCode(this.area);
        hash = 53 * hash + Objects.hashCode(this.materialPerSqFt);
        hash = 53 * hash + Objects.hashCode(this.laborPerSqFt);
        hash = 53 * hash + Objects.hashCode(this.materialTotal);
        hash = 53 * hash + Objects.hashCode(this.laborTotal);
        hash = 53 * hash + Objects.hashCode(this.taxTotal);
        hash = 53 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FMOrder other = (FMOrder) obj;
        if (!Objects.equals(this.orderNumber, other.orderNumber)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.materialType, other.materialType)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.materialPerSqFt, other.materialPerSqFt)) {
            return false;
        }
        if (!Objects.equals(this.laborPerSqFt, other.laborPerSqFt)) {
            return false;
        }
        if (!Objects.equals(this.materialTotal, other.materialTotal)) {
            return false;
        }
        if (!Objects.equals(this.laborTotal, other.laborTotal)) {
            return false;
        }
        if (!Objects.equals(this.taxTotal, other.taxTotal)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order No: " + orderNumber
                + " Name: " + customerName
                + " State: " + state
                + " Tax Rate: %" + taxRate
                + " Material: " + materialType
                + " Area: " + area
                + " Material/sq ft $" + materialPerSqFt
                + " Labor/sq ft: $" + laborPerSqFt
                + " Material total: $" + materialTotal
                + " Labor total: $" + laborTotal
                + " Tax Total: $" + taxTotal
                + " Total: $" + total;

    }

}
