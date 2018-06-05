/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalcjspservlet;

import java.math.BigDecimal;

/**
 *
 * @author Lizz
 */
public class YearlyInfo {
    private int currentYear;
    private BigDecimal initialPrinciple;
    private BigDecimal endingPrinciple;
    private BigDecimal startingPrinciple;
    private BigDecimal interestGained;
    private BigDecimal carryOverPrinciple;

    public BigDecimal getCarryOverPrinciple() {
        return carryOverPrinciple;
    }

    public void setCarryOverPrinciple(BigDecimal carryOverPrinciple) {
        this.carryOverPrinciple = carryOverPrinciple;
    }

    public BigDecimal getInterestGained() {
        return interestGained;
    }

    public void setInterestGained(BigDecimal interestGained) {
        this.interestGained = interestGained;
    }

    public BigDecimal getStartingPrinciple() {
        return startingPrinciple;
    }

    public void setStartingPrinciple(BigDecimal startingPrinciple) {
        this.startingPrinciple = startingPrinciple;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public BigDecimal getInitialPrinciple() {
        return initialPrinciple;
    }

    public void setInitialPrinciple(BigDecimal initialPrinciple) {
        this.initialPrinciple = initialPrinciple;
    }

    public BigDecimal getEndingPrinciple() {
        return endingPrinciple;
    }

    public void setEndingPrinciple(BigDecimal endingPrinciple) {
        this.endingPrinciple = endingPrinciple;
    }
    
}
