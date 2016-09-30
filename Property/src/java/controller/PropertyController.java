/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PropertyDAOImp;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Property;
import dao.PropertyDAO;

/**
 *
 * @author Diego
 */
public class PropertyController extends HttpServlet {

    private final String LISTA_PROPERTIES = "/lista_properties.jsp";
    private final String AGREGAR_CAMBIAR = "/property.jsp";
    private PropertyDAO dao;

    public PropertyController() {
        dao = new PropertyDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_PROPERTIES;
            int idSeq = Integer.parseInt(
                    request.getParameter("idSeq"));
            dao.borrarProperty(idSeq);
            request.setAttribute("properties", dao.desplegarProperties());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR;
            int idSeq = Integer.parseInt(
                    request.getParameter("idSeq"));
            Property property = dao.elegirProperty(idSeq);
            request.setAttribute("property", property);
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_CAMBIAR;
        } else {
            forward = LISTA_PROPERTIES;
            request.setAttribute("properties",
                    dao.desplegarProperties());
        }

        RequestDispatcher view
                = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Property property = new Property();
        property.setPropertyKey(request.getParameter("propertyKey"));
        property.setPropertyVal(request.getParameter("propertyVal"));

        String idSeq = request.getParameter("idSeq");

        if (idSeq == null || idSeq.isEmpty()) {
            dao.agregarProperty(property);
        } else {
            property.setIdSeq(
                    Integer.parseInt(idSeq));
            dao.cambiarProperty(property);
        }

        RequestDispatcher view
                = request.getRequestDispatcher(LISTA_PROPERTIES);
        request.setAttribute("properties",
                dao.desplegarProperties());
        view.forward(request, response);
    }
}
