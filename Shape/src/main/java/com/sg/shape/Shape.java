/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shape;

/**
 *
 * @author Lizz
 */
public abstract class Shape {
    protected String color = "red";
    
    public abstract double getArea(double x,double y);
    public abstract double getPerimeter(double x, double y);
    
    
}
