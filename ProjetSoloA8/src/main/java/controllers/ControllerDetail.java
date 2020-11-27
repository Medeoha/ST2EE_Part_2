/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static Constants.Constantes.DETAILS_VIEW_PATH;

/**
 *
 * @author narut
 */
public class ControllerDetail extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerDB</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerDB at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        if (session.getAttribute("token")!=null){

        }
        else{
            response.sendRedirect("/Controller");
        }
        //We get the intern
        String current_id_string_detail = request.getParameter("student_db_detail");
        int current_id = Integer.parseInt(current_id_string_detail);
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("my_persistence_unit");
        InternJpaController icontroller = new InternJpaController(emf);
        Intern current_intern = icontroller.findIntern(current_id);
        //Entity controllers are created
        InfoInternJpaController iicontroller = new InfoInternJpaController(emf);
        InfoIntern current_info = iicontroller.findInfoIntern(current_intern.getInfo_intern().getId());

        MissionJpaController mcontroller = new MissionJpaController(emf);
        Mission current_mission = mcontroller.findMission(current_intern.getMission().getId());

        //We update the entities
        current_info.setLastname(request.getParameter("Last_name"));
        current_info.setFirstname(request.getParameter("First_name"));
        current_info.setAddress(request.getParameter("Adresse"));
        current_mission.setMidInternshipMeetingInfo(request.getParameter("Description_mission"));
        current_mission.setCommentsOfTheIntern(request.getParameter("Description"));
        //We update the db
        try {
            iicontroller.edit(current_info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mcontroller.edit(current_mission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //We go back to the page welcome
        response.sendRedirect("/Controller");



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
        //We retrieve the internal one and send its information to detail.jsp
        String current_id_string = request.getParameter("intern_details");
        int current_id = Integer.parseInt(current_id_string);
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("my_persistence_unit");
        InternJpaController icontroller = new InternJpaController(emf);
        Intern current_teacher = icontroller.findIntern(current_id);
        request.setAttribute("key_User", current_teacher);
        request.getRequestDispatcher(DETAILS_VIEW_PATH).forward(request, response);

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
