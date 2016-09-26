<%-- 
    Document   : materia
    Created on : 24/09/2016, 07:49:48 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materia</title>
    </head>
    <body>
        <form action="MateriaController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>
                
                <div>
                <label for="idMateria">Id Materia:</label>
                <input type="text" name="idMateria"
                       value="${materia.idMateria}"
                       readonly="readonly" 
                       placeholder="Id de materia"/>
                </div>
                
                <div>
                <label for="descripcion">Descripcion:</label>
                <input type="text" name="descripcion"
                       value="${materia.descripcion}"
                       placeholder="Descripcion de la materia:"/>
                </div>
                 
                <div>
                <label for="fechaInicio">Fecha Inicio:</label>
                <input type="text" name="fechaInicio"
                       value="${materia.fechaInicio}"
                       placeholder="Fecha Inicio"/>
                </div>
                
                <div>
                <label for="fechaFin">Fecha Fin:</label>
                <input type="text" name="fechaFin"
                       value="${materia.fechaFin}"
                       placeholder="Fecha Final"/>
                </div>
                       
                <div>
                <label for="totalHoras">Total Horas:</label>
                <input type="text" name="totalHoras"
                       value="${materia.totalHoras}"
                       placeholder="Total Horas"/>
                </div>
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>

