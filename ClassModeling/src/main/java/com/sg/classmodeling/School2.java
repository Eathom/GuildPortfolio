/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classmodeling;

/**
 *
 * @author Lizz
 */
public class School2 {
    private int enrollment;
    private int numberOfTeachers;
    private String[] courses;
    private String sportsNickname;
    private String[] clubs;
    private Student[] studentRoster;
    
    public void enrollStudent(Student student){
        
    }
    public void unenrollStudent(Student student){
        
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }

    public void setNumberOfTeachers(int numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public String getSportsNickname() {
        return sportsNickname;
    }

    public void setSportsNickname(String sportsNickname) {
        this.sportsNickname = sportsNickname;
    }

    public String[] getClubs() {
        return clubs;
    }

    public void setClubs(String[] clubs) {
        this.clubs = clubs;
    }

    public Student[] getStudentRoster() {
        return studentRoster;
    }

    public void setStudentRoster(Student[] studentRoster) {
        this.studentRoster = studentRoster;
    }
    
    
    
    
}
