package com.emergentes.controller;

import com.emergentes.bean.BeanEstudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanEstudiante dao = new BeanEstudiante();

        Estudiante estudiante = new Estudiante();
        long id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        switch (action) {
            case "add":
                request.setAttribute("estudiante", estudiante);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "edit":
                id = Long.parseLong(request.getParameter("id"));

                estudiante = dao.buscar(id);
                request.setAttribute("estudiante", estudiante);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);

                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(id);

                response.sendRedirect("MainController");

                break;
            case "view":
                List<Estudiante> lista = new ArrayList<Estudiante>();
                lista = dao.listarTodos();
                request.setAttribute("estudiantes", lista);
                request.getRequestDispatcher("estudiantes.jsp").forward(request, response);

                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String fechaNacimiento = request.getParameter("fechaNacimiento");

        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        estudiante.setNombre(nombre);
        estudiante.setApellidos(apellidos);
        estudiante.setEmail(email);
        estudiante.setFechaNacimiento(convierteFecha(fechaNacimiento));

        BeanEstudiante dao = new BeanEstudiante();
        if (id == 0) {
            dao.insertar(estudiante);
        } else {
            dao.editar(estudiante);
        }

        response.sendRedirect("MainController");
    }
    
    private void nuevo() {
        BeanEstudiante dao = new BeanEstudiante();

        Estudiante e = new Estudiante();
        e.setNombre("Armando ");
        e.setApellidos("Terrazas");
        e.setEmail("armando@gmail.com");
        e.setFechaNacimiento(java.sql.Date.valueOf("11-11-2002"));

        dao.insertar(e);
        
    }


    private void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanEstudiante dao = new BeanEstudiante();
        List<Estudiante> lista = dao.listarTodos();
        request.setAttribute("estudiantes", lista);
        request.getRequestDispatcher("estudiantes.jsp").forward(request, response);

    }
    
     
    private void editar() {
        BeanEstudiante dao = new BeanEstudiante();

        long id = 2;
        Estudiante e = dao.buscar(id);

        e.setNombre("Richar");
        e.setApellidos("Gutierres");
        e.setEmail("richar@gmail.com");
        dao.editar(e);
    }

    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        BeanEstudiante dao = new BeanEstudiante();

        dao.eliminar(id);
        response.sendRedirect("MainController");

    }

    public java.sql.Date convierteFecha(String fecha) {
        java.sql.Date fechaBD = null;

        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new java.sql.Date(fechaTMP.getTime());
        } catch (ParseException ex) {

        }

        return fechaBD;
    }

}
