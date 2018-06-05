
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lizz
 */
public class FieldDay {
    public static void main(String[] args) {
        String rd, dm, mc, gs, ng, bh, lastName;
        rd = "red dragons";
        dm = "dark wizards";
        mc = "moving castles";
        gs = "golden snitches";
        ng = "night guards";
        bh = "black holes";
        
        
        Scanner sc = new Scanner(System.in);
        //for statement to run multiple times for scenarios
        
       /* for (int i=0; i <20; i++ ){
        System.out.println("Last name?");
        lastName = sc.nextLine();
        
        //using else if to replace if after Baggins but before dresden
        if (lastName.compareToIgnoreCase("Baggins") < 0)  {
            System.out.println("you're on team " + rd);
        } else if (lastName.compareToIgnoreCase("Dresden") < 0)  {
            System.out.println("you're on team " + dm);
        } else if (lastName.compareToIgnoreCase("Howl") < 0)  {
            System.out.println("you're on team " + mc);
        } else if (lastName.compareToIgnoreCase("Potter") < 0)  {
            System.out.println("you're on team " + gs);
        } else if (lastName.compareToIgnoreCase("Vimes") < 0)  {
            System.out.println("you're on team " + ng);
        } else if (lastName.compareToIgnoreCase("Vimes") > 0)  {
            System.out.println("you're on team " + bh);
        }
        }
        
  */
        System.out.println("Last name 2nd way");
        lastName = sc.nextLine();
        if (lastName.compareToIgnoreCase("Baggins") < 0) {
            System.out.println(rd);
        } else if (lastName.compareToIgnoreCase("Baggins") > 0 && (lastName.compareToIgnoreCase("Dresden")) < 0) {
            System.out.println(dm);
        }
        
        
    }
}


Which way is better? Both work