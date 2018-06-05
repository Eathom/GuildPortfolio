/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class App {
    public static void main(String[] args) throws Exception {
        
        
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        out.println("This is a line");
        out.println("Doo doo doo");
        out.println("Salebueelj looooby doo");
        
        out.flush();
        out.close();
        
        
        
        Scanner sc = new Scanner (
        new BufferedReader(new FileReader("OutFile.txt")));
        
        while(sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
        System.out.println("That's all the content");
    }
    
}
