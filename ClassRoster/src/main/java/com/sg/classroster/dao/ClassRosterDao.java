/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Lizz
 */
public interface ClassRosterDao {

    
 /** add student to roster, and assoc. it with student id.
  * if there is already a student assoc with the student id it will return
  * the student object, or else null.
  * 
  * @param studentId id with which student is to be assoc
  * @param student student to be added to roster
  * @return the Student object previously assoc with id, if it exists, otherwise null.
  * @throws com.sg.classroster.dao.ClassRosterPersistenceException
  */   

Student addStudent(String studentId, Student student)
        throws ClassRosterPersistenceException;

/**
 * Return studen object assoc with id.
 * returns null if no student exists.
 * 
 * @param studentId Id of student to retreive
 * @return the Student object assoc with given id
 * @throws com.sg.classroster.dao.ClassRosterPersistenceException
 */

Student getStudent(String studentId)
        throws ClassRosterPersistenceException;

/** 
 * Return a String array of all student ids of students in roster.
 * 
 * @return String array containing all ids
 * @throws com.sg.classroster.dao.ClassRosterPersistenceException
 */




List<Student> getAllStudents()
        throws ClassRosterPersistenceException;

/**
 * Removes from the roster the student assoc with id.
 * returns the student object that is being removed or null if no student.
 * 
 * @param StudentId id of student to be removed
 * @return Student object removed, or null.
 */
Student removeStudent(String studentId)
        throws ClassRosterPersistenceException;
}