/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class App {
    public static void main(String[] args) {

       

getCommand();

       
    
    }
public static void getCommand(){
     Integer command;
    Classroom mine = new Classroom();
    Scanner sc = new Scanner(System.in);
    
    mine.addStudent("Tom");
    mine.addStudent("Blake");
    mine.addStudent("Tina");
    
    System.out.println(mine.viewClassroomHigh());
   
    /*
 
    do {
        do {
            System.out.println("Enter number: 1. view students 2. add a student 3. remove a student 4. view a student's scores 5. view a student's average score \n 6. view classroom average 7. view Highest score 8. view lowest score 9. exit");
            command = sc.nextInt();
            sc.nextLine();
            //check in bounds
         } while (command < 1 || command > 9);
   
        switch (command) {
           case 1: System.out.println(mine.viewStudents());
                    break;
           case 2: mine.addStudent(mine.getStudent("Who would you like to add?"));
                    break;
           case 3: mine.removeStudent(mine.getStudent("Who would you like to remove?"));
                    break;
           case 4: System.out.println(mine.viewStudentScore(mine.getStudent("Whose scores would you like to view?"))); 
                    break;
           case 5: System.out.println(mine.viewStudentAvg(mine.getStudent("Whose average score would you like to view?")));
                    break;
           case 6: System.out.println(mine.viewClassroomAvg());
                    break;
           case 7: mine.viewClassroomHigh();
                        System.out.println(mine.highScores);
                    break;
           case 8: System.out.println(mine.viewClassroomLow());
       }
        
       
        //exit if not in bounds
    }while(!(command == 9));
    System.out.println("Thank you");
    */
}    
    
}

