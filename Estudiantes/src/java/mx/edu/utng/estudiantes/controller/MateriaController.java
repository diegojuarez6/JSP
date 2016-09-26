/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.estudiantes.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.estudiantes.dao.MateriaDAO;
import mx.edu.utng.estudiantes.dao.MateriaDAOImp;
import mx.edu.utng.estudiantes.model.Materia;


/**
 *
 * @author Diego
 */
public class MateriaController extends HttpServlet {
   private static final String
           LISTA_MATERIAS = "/lista_materias.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "/materia.jsp";
   private MateriaDAO dao;
   
   public MateriaController(){
       dao = new MateriaDAOImp();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_MATERIAS;
            int idMateria = Integer.parseInt(
                request.getParameter("idMateria"));
            dao.borrarMateria(idMateria);
            request.setAttribute("materias",
                    dao.desplegarMaterias());
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idMateria = Integer.parseInt(
                request.getParameter("idMateria"));
             Materia materia = 
                     dao.elegirMateria(idMateria);
             request.setAttribute("materia", materia);
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
         } else{
             forward = LISTA_MATERIAS;
             request.setAttribute("materias", 
                     dao.desplegarMaterias());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Materia materia = new Materia();
        materia.setDescripcion(request.getParameter("descripcion"));
        materia.setFechaInicio(request.getParameter("fechaInicio"));
        materia.setFechaFin(request.getParameter("fechaFin"));
        materia.setTotalHoras(Integer.parseInt(
                request.getParameter("totalHoras")));
        String idMateria = request.getParameter("idMateria");
        
        if(idMateria==null|| idMateria.isEmpty()||idMateria.trim().equals("")){
            dao.agregarMateria(materia);
        }else{
            materia.setIdMateria(
                    Integer.parseInt(idMateria));
            dao.cambiarMateria(materia);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_MATERIAS);
        request.setAttribute("materias", 
                dao.desplegarMaterias());
        view.forward(request, response);
    }
    
}
