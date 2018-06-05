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
public class Square extends Shape{
    double height = 5; 
    double width = 5;
    
  @Override
    public double getArea(double height, double width){
        return height * width;
    }
    
  
    @Override
    public double getPerimeter(double height, double width){
        return (height + width) * 2;
    }

}