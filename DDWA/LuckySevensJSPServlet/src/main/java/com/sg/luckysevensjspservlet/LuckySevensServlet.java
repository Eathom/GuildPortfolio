/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensjspservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lizz
 */
@WebServlet(name = "LuckySevensServlet", urlPatterns = {"/LuckySevensServlet"})
public class LuckySevensServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String input = request.getParameter("betAmount");
        int betAmount = Integer.parseInt(input);

        int roll;
        int countRoll = 0;
        int rollWithMaxMoney = 0;
        int maximumMoney = 0;
        int win = 4;
        int lose = 1;

        while (betAmount > 0) {
            
            if (maximumMoney < betAmount) {
                maximumMoney = betAmount;
                rollWithMaxMoney = countRoll;
            }
            
            roll = rollDice();
            countRoll++;
            

            if (roll == 7) {
                betAmount += win;
            } else {
                betAmount -= lose;
            }

        }

        request.setAttribute("input", input);
        request.setAttribute("countRoll", countRoll);
        request.setAttribute("rollWithMaxMoney", rollWithMaxMoney);
        request.setAttribute("maximumMoney", maximumMoney);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    private int rollDice() {
        Random rGen = new Random();
        int diceOne = rGen.nextInt(6) + 1;
        int diceTwo = rGen.nextInt(6) + 1;
        int sum = diceOne + diceTwo;
        return sum;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
