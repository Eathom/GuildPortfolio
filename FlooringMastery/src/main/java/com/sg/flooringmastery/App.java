/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery;

import com.sg.flooringmastery.controller.FMController;
import com.sg.flooringmastery.dao.FMDao;
import com.sg.flooringmastery.dao.FMDaoDataPersistException;
import com.sg.flooringmastery.enums.FMModeSelection;
import com.sg.flooringmastery.service.FMServiceLayer;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Lizz
 */
public class App {

    public static void main(String[] args) throws FMDaoDataPersistException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a mode: 1. Training 2. Production");
        String strSelection = sc.nextLine();
        int intSelection = Integer.parseInt(strSelection);

        FMModeSelection mode = FMModeSelection.getMode(intSelection);

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        if (mode == FMModeSelection.PRODUCTION) {
            FMServiceLayer service = ctx.getBean("service", FMServiceLayer.class);
            service.setDao(ctx.getBean("productionDao", FMDao.class));
        } else {
            FMServiceLayer service = ctx.getBean("service", FMServiceLayer.class);
            service.setDao(ctx.getBean("trainingDao", FMDao.class));
        }

        FMController controller
                = ctx.getBean("controller", FMController.class);

        controller.execute();

    }
}
