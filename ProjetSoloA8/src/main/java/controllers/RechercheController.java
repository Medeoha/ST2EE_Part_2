package controllers;

import Models.Teacher;
import Models.TeacherJpaController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Constants.Constantes.SEARCH_VIEW_PATH;
import static Constants.Constantes.WELCOME_VIEW_PATH;

@WebServlet(name = "RechercheController")
public class RechercheController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("Search_value");
        String current_id_string = request.getParameter("Search_id");
        System.out.println(current_id_string);
        int current_id_teacher = Integer.parseInt(current_id_string);

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("my_persistence_unit");
        TeacherJpaController cteacher = new TeacherJpaController(emf);
        Teacher t  = cteacher.findTeacher(current_id_teacher);
        request.getSession().setAttribute("Search_key", t);
        request.getSession().setAttribute("ContainSearch",c);

        request.getRequestDispatcher(SEARCH_VIEW_PATH).forward(request, response);
    }
}
