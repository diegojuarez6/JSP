<%-- 
    Document   : lista_materias
    Created on : 24/09/2016, 07:50:47 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Materias</title>
    </head>
    <body>
        <table>
            <thead>  
            <tr>
                <th>Id de materia</th>
                <th>Descripcion</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Total Horas</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="materia" 
                           items="${materias}">
                    <tr>
                        <td>${materia.idMateria}</td>
                        <td>${materia.descripcion}</td>
                        <td>${materia.fechaInicio}</td>
                        <td>${materia.fechaFin}</td>
                        <td>${materia.totalHoras}</td>
                        <td><a href="MateriaController?action=cambiar&idMateria=${materia.idMateria}">Cambiar</a></td>
                        <td><a href="MateriaController?action=borrar&idMateria=${materia.idMateria}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="MateriaController?action=agregar">
                Agregar Materia
            </a>
        </p>
    </body>
</html>

