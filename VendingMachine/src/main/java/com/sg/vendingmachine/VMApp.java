/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VMController;
import com.sg.vendingmachine.dao.VMDaoDataPersistException;
import com.sg.vendingmachine.dto.VMMoneyInMachine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Lizz
 */
public class VMApp {

    public static void main(String[] args) throws VMDaoDataPersistException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        VMController controller = ctx.getBean("controller", VMController.class);

        controller.run();

    }
}
