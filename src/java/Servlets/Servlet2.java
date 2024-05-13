/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Servlet2", urlPatterns = {"/Servlet2"}, initParams = {
    @WebInitParam(name = "emailDefault", value = "saul.domiguez@lania.edu.mx"),
    @WebInitParam(name = "param2", value = "34")})
public class Servlet2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ﻿protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    
    getServletContext()
            .getRequestDispatcher("/Servlet3")
            .include(request, response);
    
    response.setContentType("text/html; charset=UTF-8"); 
    try (PrintWriter out = response.getWriter()) { 
        out.println("<!DOCTYPE html>"); 
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet2</title>");
        out.println("</head>"); 
        out.println("<body>");
        out.println("<h1>Servlet2</h1>");
        if (request.getAttribute("random") != null) {
            out.println("<p>Numero aleatorio generado en Servlet3:<br/><h2>" + 
                    request.getAttribute("random") + "</h2></p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
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
    }
