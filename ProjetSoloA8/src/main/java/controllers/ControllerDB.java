/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.*;
import com.google.protobuf.TextFormat;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author narut
 */
public class ControllerDB extends HttpServlet {

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
        ArrayList<Teacher> listOfTeacher;
        TeacherTest Ttest;
        if (session.getAttribute("token")!=null){

        }
        else{
            response.sendRedirect("/Login");
        }
        String current_id_string = request.getParameter("teachere");
        System.out.println("ICIIIIIII PUTAIN" + current_id_string);
        System.out.println("ICIIIIIII PUTAIN" + current_id_string);
        int current_id = Integer.parseInt(current_id_string);
        Date date_random = null;
        try {
            date_random = new SimpleDateFormat("yyyy-MM-dd").parse("1998-12-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("my_persistence_unit");
        TeacherJpaController tcontroller = new TeacherJpaController(emf);
        Teacher current_teacher = tcontroller.findTeacher(current_id);

        VisitSheet vs = new VisitSheet(false,false);

        EvalSheet es = new EvalSheet("Defaut", 1,1,false);
        
        InfoIntern in = new InfoIntern("Defaut", "Defaut", "Defaut", "Defaut", "Defaut", "Defaut", date_random );
        Mission mission = new Mission(1900,date_random,date_random,"Defaut","Defaut","Defaut",false,"Defaut",es, vs);
        Intern intern = new Intern(mission,in,current_teacher);

       InfoInternJpaController iicontroller = new InfoInternJpaController(emf);
       // InfoIntern current_info = iicontroller.findInfoIntern(in.getId());

        VisitSheetJpaController vscontroller = new VisitSheetJpaController(emf);
        //VisitSheet current_vs = vscontroller.findVisitSheet(vs.getId());

        EvalSheetJpaController escontroller = new EvalSheetJpaController(emf);
       // EvalSheet current_es = escontroller.findEvalSheet(es.getId());

        MissionJpaController mcontroller = new MissionJpaController(emf);
       // Mission current_mission = mcontroller.findMission(mission.getId());

        InternJpaController icontroller = new InternJpaController(emf);
        //Intern current_intern = icontroller.findIntern(intern.getId());

        iicontroller.create(in);
        escontroller.create(es);
        vscontroller.create(vs);
        mcontroller.create(mission);
        icontroller.create(intern);
        /*Ttest = new TeacherTest();
        listOfTeacher = new ArrayList<>();
        listOfTeacher.addAll(Ttest.getallTeacher());
        request.setAttribute("key_User", listOfTeacher);*/
        //request.getRequestDispatcher("welcome.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        if (session.getAttribute("token")!=null){

        }
        else{
            response.sendRedirect("/Login");
        }


        String current_id_string = request.getParameter("eleve_db");
        System.out.println(current_id_string);
        int current_id_intern = Integer.parseInt(current_id_string);



        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("my_persistence_unit");
        InternJpaController icontroller = new InternJpaController(emf);
        Intern current_intern = icontroller.findIntern(current_id_intern);

        InfoInternJpaController iicontroller = new InfoInternJpaController(emf);
        InfoIntern current_info = iicontroller.findInfoIntern(current_intern.getInfo_intern().getId());

        VisitSheetJpaController vscontroller = new VisitSheetJpaController(emf);
        VisitSheet current_vs = vscontroller.findVisitSheet(current_intern.getMission().getVisit_sheet().getId());

        EvalSheetJpaController escontroller = new EvalSheetJpaController(emf);
        EvalSheet current_es = escontroller.findEvalSheet(current_intern.getMission().getEval_sheet().getId());

        MissionJpaController mcontroller = new MissionJpaController(emf);
        Mission current_mission = mcontroller.findMission(current_intern.getMission().getId());

        current_info.setInternGroup(request.getParameter("GroupStudent").replaceAll("\\s",""));
        current_info.setFirstname(request.getParameter("LastNameStudent").replaceAll("\\s",""));




        if(request.getParameter("soutenance") != null)
        {
            current_mission.setSoutenance(true);
        }
        else
        {
            current_mission.setSoutenance(false);
        }

        /*--------------------------------------------------------------------------*/
        if(request.getParameter("plannif") != null)
        {
            current_vs.setVisitPlanned(true);
        }
        else
        {
            current_vs.setVisitPlanned(false);
        }
        if(request.getParameter("faite") != null)
        {
            current_vs.setVisitDone(true);
        }
        else
        {
            current_vs.setVisitDone(false);
        }

        try {

            current_mission.setStartMission(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Debut")) );
            current_mission.setEndMission(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Fin")) );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        current_info.setAddress(request.getParameter("Adresse"));
        int notecom = Integer.parseInt(request.getParameter("NoteCom"));
        int notetech = Integer.parseInt(request.getParameter("NoteTech"));

        current_es.setGradeCom(notecom);
        current_es.setGradeTech(notetech);
        /*--------------------EDIT PART---------------------------*/
        try {
            escontroller.edit(current_es);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            vscontroller.edit(current_vs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mcontroller.edit(current_mission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            iicontroller.edit(current_info);
            System.out.println("ON EST PASSE PAR ICI");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //request.getSession().setAttribute("key_User", current_intern.getTeacher());
        //request.getRequestDispatcher("welcome.jsp").forward(request, response);
        response.sendRedirect("/Controller");



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
