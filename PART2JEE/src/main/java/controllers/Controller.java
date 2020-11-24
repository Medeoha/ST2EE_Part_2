/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author narut
 */
public class Controller extends HttpServlet {
    private ArrayList<Teacher> listOfTeacher;
    private TeacherTest Ttest;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */EntityManagerFactory emf;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ttest = new TeacherTest();
        listOfTeacher = new ArrayList<>();
        listOfTeacher.addAll(Ttest.getallTeacher());
        Teacher t2 = new Teacher(5,"Vincent", "Masson","123","123");
        emf =  Persistence.createEntityManagerFactory("my_persistence_unit");
        TeacherJpaController tmp = new TeacherJpaController(emf);
          for(Teacher t :  listOfTeacher)
          {
              if(request.getParameter("loginForm").equals(t.getLogin()) && request.getParameter("pwdForm").equals(t.getPassword()))
              {
                  
                  tmp.create(t2);
                  emf.close();
                  request.getSession().setAttribute("key_User", t);
                  request.getRequestDispatcher("welcome.jsp").forward(request, response);
                

              }
                        
          }
          request.getRequestDispatcher("index.jsp").forward(request, response);
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
