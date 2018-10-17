/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;
import java.util.Objects;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Lizz
 */
public class InputFormObject {

    private BigDecimal total = BigDecimal.ZERO;

    @NotEmpty(message = "Please select an item to vend")
    private String itemSelectedIdString;

    private String change = "";
    private String message = "";

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.total);
        hash = 41 * hash + Objects.hashCode(this.itemSelectedIdString);
        hash = 41 * hash + Objects.hashCode(this.change);
        hash = 41 * hash + Objects.hashCode(this.message);
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
        final InputFormObject other = (InputFormObject) obj;
        if (!Objects.equals(this.itemSelectedIdString, other.itemSelectedIdString)) {
            return false;
        }
        if (!Objects.equals(this.change, other.change)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }

        return true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getItemSelectedIdString() {
        return itemSelectedIdString;
    }

    public void setItemSelectedIdString(String itemSelectedIdString) {
        this.itemSelectedIdString = itemSelectedIdString;
    }

}
