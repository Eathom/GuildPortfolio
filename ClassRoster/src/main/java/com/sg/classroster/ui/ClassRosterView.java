/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class ClassRosterView {
    private UserIO io;
    
    public ClassRosterView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection(){
        io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student");
            io.print("3. View a student");
            io.print("4. Remove a student");
            io.print("5. Exit");
            
       return io.readInt("Please select from above choices.", 1, 5);     
    
    }
    
    
    public Student getNewStudentInfo(){
        String studentId = io.readString("Enter Student ID");
        String firstName = io.readString("Enter first name");
        String lastName = io.readString("Enter last name");
        String cohort = io.readString("Enter Cohort");
        
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent; 
    }
    
    public void displayCreateStudentBanner(){
        io.print("=== Create Student ===");
    }
    
    public void displayCreateSuccessBanner(){
        io.readString("Student successfully created. Hit enter to continue.");
    }
    
    public void displayStudentList(List<Student> studentList){
        for (Student currentStudent : studentList){
            io.print(currentStudent.getStudentId() + ": " + currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }
        io.readString("Hit enter to continue");
    }
    
    public void displayDisplayAllBanner(){
        io.print("=== Display All Students ===");
    }
    
    public void displayDisplayStudentBanner(){
        io.print("=== Display Student ===");
    }
    
    public String getStudentIdChoice(){
        return io.readString("Enter Student ID");
    }
    
    public void displayStudent(Student student){
        if (student != null){
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student");
        }
        io.readString("Hit enter to continue.");
    }
    
    public void displayRemoveBanner(){
        io.print("=== Remove Student ===");
    }
    
    public void displayRemoveSuccessBanner(){
        io.readString("Student removed. Hit enter to continue");
     }
    
    
    public void displayExitBanner() {
        io.print("Good bye!");
    }
  
    public void displayUnknownCommand() {
        io.print("Unknown command");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
   
}
