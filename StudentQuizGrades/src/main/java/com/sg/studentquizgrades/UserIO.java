/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Lizz
 */
public interface UserIO {
    //INPUTS
 

  String getStudent(String prompt);
          
    //OUTPUTS
    Set viewStudents();
    void addStudent(String student);
    void removeStudent(String student);
    ArrayList viewStudentScore(String student);
    Integer viewStudentAvg(String student);
    Integer viewClassroomAvg();
    Map<Integer, ArrayList<String>> viewClassroomHigh();
    void viewClassroomLow();
    
    
}
