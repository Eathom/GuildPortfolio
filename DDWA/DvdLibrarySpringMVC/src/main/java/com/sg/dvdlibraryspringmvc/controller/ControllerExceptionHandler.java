/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.controller;

import com.sg.dvdlibraryspringmvc.dao.ErrorMessage;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Lizz
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorMessage processValidationException(MethodArgumentNotValidException e){
        BindingResult r = e.getBindingResult();
        List<FieldError> fe = r.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        
        sb.append("Your errors:");
        
        for (FieldError current: fe){
            sb.append("[");
            sb.append(current.getField());
            sb.append(":");
            sb.append(current.getDefaultMessage());
            sb.append("]");
            
            
        }
        
        ErrorMessage myError = new ErrorMessage();
        myError.setErrorMessage(sb.toString());
        return myError;
    }
    
      @ExceptionHandler(UpdateIntegrityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorMessage processIntegrityException(MethodArgumentNotValidException e){
        BindingResult r = e.getBindingResult();
        List<FieldError> fe = r.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        
        sb.append("Your errors:");
        
        for (FieldError current: fe){
            sb.append("[");
            sb.append(current.getField());
            sb.append(":");
            sb.append(current.getDefaultMessage());
            sb.append("]");
            
            
        }
        
        ErrorMessage myError = new ErrorMessage();
        myError.setErrorMessage(sb.toString());
        return myError;
    }
}
