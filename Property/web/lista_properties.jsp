<%-- 
    Document   : lista_properties
    Created on : 29/09/2016, 02:57:19 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Properties</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id Seq</th>
                    <th>Property Key</th>
                    <th>Property Val</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${properties}" var="property">
                    <tr>
                        <td>${property.idSeq}</td>
                        <td>${property.propertyKey}</td>
                        <td>${property.propertyVal}</td>
                        <td>
                            <a href="PropertyController?action=cambiar&idSeq=${property.idSeq}">Cambiar</a>
                        </td>
                        <td>
                            <a href="PropertyController?action=borrar&idSeq=${property.idSeq}">Borrar</a>
                        </td>
                    
                    </tr>
                </c:forEach>
            </tbody>    
            
        </table>
        <p>
            <a href="PropertyController?action=agregar">Agregar properties</a>
        </p>
    </body>
</html>
