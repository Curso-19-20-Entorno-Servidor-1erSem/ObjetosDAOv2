/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.AlumnosDAO;
import es.albarregas.DAO.IAlumnosDAO;
import es.albarregas.DAOfactory.DAOFactory;
import es.albarregas.beans.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author franciscoantonio
 */

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cantidad = request.getParameter("numero");
        String clausulaWhere = "";
        String url = "";
        boolean error = false;

        if (request.getParameter("all") != null) {
            clausulaWhere = "";
        } else if (cantidad != null) {
            clausulaWhere = " limit " + cantidad;
        } else {
            error = true;
        }

        if (!error) {
            if (request.getParameter("all").equals("equipo")) {
                IAlumnosDAO adao = new AlumnosDAO();
                ArrayList<Alumno> alumnosYequipos = adao.getAlumnosEquipo();

                request.setAttribute("alumnosYequipos", alumnosYequipos);
                url = "../JSP/listaEquiposAlumnos.jsp";
            } else {
                DAOFactory daof = DAOFactory.getDAOFactory(1);
                IAlumnosDAO odao = daof.getAlumnosDAO();
                ArrayList<Alumno> alumnos = odao.getAlumnos(clausulaWhere);

                request.setAttribute("alumnos", alumnos);
                url = "../JSP/listaAlumnos.jsp";
            }
            
        } else {
            request.setAttribute("error", "No se han pasado parámetros");
            url = "../JSP/error.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);
    }


}
