/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DvdController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Lizz
 */
public class App {

    public static void main(String[] args) throws Exception {

 /*       
UserIO io = new UserIOConsoleImpl();
        DvdView view = new DvdView(io);
        DvdDao dao = new DvdDaoFileImpl();
       DvdController controller = new DvdController(dao, view);
        
    
       
       
      controller.run();
*/
 
 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
 DvdController controller = ctx.getBean("controller", DvdController.class);
 
 controller.run();

    }
    
}
