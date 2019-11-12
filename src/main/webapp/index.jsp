<%-- 
    Document   : index
    Created on : 11 nov. 2019, 13:23:49
    Author     : franciscoantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/avesStyle.css">
        <%@include file="/INC/metas.inc"%>
        <title>ObjetosDAOv2</title>
    </head>
    <body>
            <form action="Controlador" method="post">
            
            <label>Introduce número de alumnos: </label><input type="number" name="numero"></br>
            <button type="submit" name="enviar" value="enviar"> Mostrar el número de alunmos introducidos
            <button type="submit" name="all" value="alumnos">Mostrar todos los alumnos
            <button type="submit" name="all" value="equipo">Mostrar alumnos y equipos
            
        </form>
    </body>
</html>
