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
import javax.servlet.http.HttpSession;

import static Constants.Constantes.LOGIN_VIEW_PATH;
import static Constants.Constantes.WELCOME_VIEW_PATH;

/**
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
     */
    EntityManagerFactory emf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Ttest = new TeacherTest();
        HttpSession session = request.getSession();
        listOfTeacher = new ArrayList<>();
        listOfTeacher.addAll(Ttest.getallTeacher());
        if(session.getAttribute("token")==null) {
            request.getSession().setAttribute("loginForme", request.getParameter("loginForm"));
            request.getSession().setAttribute("pwdForme", request.getParameter("pwdForm"));
        }

          for(Teacher t :  listOfTeacher)
          {
              //if(request.getParameter("loginForm").equals(t.getLogin()) && request.getParameter("pwdForm").equals(t.getPassword()))
              if(request.getSession().getAttribute("loginForme").equals(t.getLogin()) && request.getSession().getAttribute("pwdForme").equals(t.getPassword()))
              {

                  session.setAttribute("token",t.getId());
                  request.getSession().setAttribute("key_User", t);
                  request.getRequestDispatcher("welcome.jsp").forward(request, response);
              }
                        
          }
          System.out.println("ERROR");
          request.getRequestDispatcher("index.jsp").forward(request, response);*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("token") == null) // If the user isn't connected load the login page
        {
            request.getRequestDispatcher(LOGIN_VIEW_PATH).forward(request, response);
        } else {
            doPost(request, response);
        }


    }


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ttest = new TeacherTest();
        HttpSession session = request.getSession();
        listOfTeacher = new ArrayList<>();
        listOfTeacher.addAll(Ttest.getallTeacher());
        if (session.getAttribute("token") == null) {
            request.getSession().setAttribute("loginForme", request.getParameter("loginForm"));
            request.getSession().setAttribute("pwdForme", request.getParameter("pwdForm"));
        }

        for (Teacher t : listOfTeacher) {
            if (request.getSession().getAttribute("loginForme").equals(t.getLogin()) && request.getSession().getAttribute("pwdForme").equals(t.getPassword())) //if login & pwd are correct , the user can access the database
            {
                //the id of the teacher who logged in becomes a token that allows him to connect to the rest of the application and modify the database.
                session.setAttribute("token", t.getId());
                request.getSession().setAttribute("key_User", t);
                request.getRequestDispatcher(WELCOME_VIEW_PATH).forward(request, response);
            }

        }
        request.setAttribute("errMsg", "Error");
        request.getRequestDispatcher(LOGIN_VIEW_PATH).forward(request, response);
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
