/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Lizz
 */
public  class Classroom implements UserIO {
    
    
    // Map is student to score as a list pairs.
   private Map<String , ArrayList<Integer>> classroom = new HashMap<>();
  private Collection<ArrayList<Integer>> allScores = classroom.values();
   //to view keys as set
    private Set<String> students = classroom.keySet();
   private Integer input = 0;
   Scanner sc = new Scanner(System.in);
   
   
    
    @Override
    public Set viewStudents(){
        return students;
   }
    
    
    @Override
    public void addStudent(String student){
        //  add student and list of scores
        classroom.put(student, getScore());
        
        //clear any scores added in for other students so ArrayList can be reused.
        
   }
    
    
    @Override
    public void removeStudent(String student){
        classroom.remove(student);
    }
    
    
    @Override
    public ArrayList viewStudentScore(String student){
       return classroom.get(student);
        }
    
  @Override  
 public Integer viewStudentAvg(String student){
     //create ArrayList to iterate through.
ArrayList<Integer> currentStudentScore = new ArrayList<>();

 int total = 0;
    //fill ArrayList with values from classroom HashMap.
    currentStudentScore = classroom.get(student);
    
    for (Integer e : currentStudentScore){
        
 //add elements of ArrayList to total.  
        total += e;
    }
  return (total / currentStudentScore.size());  
} 


@Override
public String getStudent(String prompt){
    System.out.println(prompt);
    return sc.nextLine();
}

@Override
public Integer viewClassroomAvg(){
    Integer total = 0;
    Integer count = 0;
    //List<Integer>scoreSet if using Linked list.
    for (ArrayList<Integer> scoreSet : allScores){
        System.out.println(scoreSet);
        count += scoreSet.size();
        for (Integer score : scoreSet){
            System.out.println(score);
            total += score;
            
            
        }
    }
    return total/count;
    }
   
 
 
 @Override
public Map<Integer, ArrayList<String>> viewClassroomHigh(){
Integer highest = -1;
Map<Integer, ArrayList<String>> top = new HashMap<>();
ArrayList<String> topStudent = new ArrayList<>();
//create new hashmap for highestScore to Student.

for (String student : students){
ArrayList<Integer> currentScores = classroom.get(student);
for (Integer score : currentScores){
    if (score >= highest){
        highest = score;
        topStudent.add(student);
   } else if (score < highest){
       topStudent.remove(student);
   }
    }
}
top.put(highest, topStudent);
return top;
/*
for (String e: topStudent){
    System.out.println("Students: " + e + " Scored highest: " + highest); 
} */
}




    



    
@Override
public void viewClassroomLow(){
      int lowest = 101;
ArrayList<String> lowestStudents = new ArrayList<>();
//create new hashmap for highestScore to Student.

for (String student : students){
ArrayList<Integer> currentScores = classroom.get(student);
for (Integer score : currentScores){
    if (score <= lowest){
        lowest = score;
        lowestStudents.add(student);
   } else if (score > lowest){
       lowestStudents.remove(student);
   }
    }
}
for (String e: lowestStudents){
    System.out.println("Students: " + e + " Scored highest: " + lowest); 
}
}
    
public ArrayList getScore(){
     //ArrayList is the scores to be paired with students.
      //?? if construct List<> scores = new ArrayList, scores is incompatible with map
     ArrayList<Integer> scores = new ArrayList<>();
       //will need to add scores into a new ArrayList
    do {
           System.out.println("Add a score. If all scores added, enter -1");
           
               input = sc.nextInt();
         
           //try catch input mismatch exception
           sc.nextLine();
            scores.add(input);
       } while (input >= 0 && input <= 100);
    //remove -1 from scores.
        scores.remove((scores.size()-1));
        return scores;

}
}


    
   
    
    

