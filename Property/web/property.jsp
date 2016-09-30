<%-- 
    Document   : property
    Created on : 29/09/2016, 03:00:09 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form action="PropertyController" method="post">
            <fieldset>
                <legend>Registro de Properties</legend>
                <div>
                    <label for="idSeq">Id Seq</label>
                    <input type="text" name="idSeq"
                           value="${property.idSeq}"
                           placeholder="Id de Property"
                           readonly="readonly" />
                </div>
                <div>
                    <label for="propertyKey">Property Key</label>
                    <input type="text" name="propertyKey"
                           value="${property.propertyKey}"
                           placeholder="Property Key"
                           />
                </div>
                <div>
                    <label for="propertyVal">Property Val</label>
                    <input type="text" name="propertyVal"
                           value="${property.propertyVal}"
                           placeholder="Property Val"
                           />
                </div>
                 <div>
                     <input type="submit" value="Guardar" />
                 </div>           
            </fieldset>
        </form>
    </body>
</html>
