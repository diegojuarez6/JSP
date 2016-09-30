<%-- 
    Document   : index
    Created on : 29/09/2016, 02:55:26 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Property</title>
    </head>
    <body>  
         <jsp:forward 
            page="PropertyController?action=listar"></jsp:forward>
    </body>
</html>