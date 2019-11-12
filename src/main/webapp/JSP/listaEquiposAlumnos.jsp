<%-- 
    Document   : listaEquipos
    Created on : 8 nov. 2019, 17:30:01
    Author     : franciscoantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/INC/metas.inc"%>
        <title>Alumnos y Equipos.</title>
    </head>
    <body>
        <h1>Alumnos y equipos: </h1>
        <p>Nombre | Grupo | Equipo</p>
        <c:forEach var="alumnoEquipo" items="${alumnosYequipos}">
           Nombre: ${alumnoEquipo.nombre} | Grupo: ${alumnoEquipo.grupo} | Equipo: ${alumnoEquipo.equipo.marca} con id ${alumnoEquipo.equipo.idEquipo}<br>
        </c:forEach>

        <br><br>
        <c:url var="index" value="/index.jsp"/>
        <a href="${index}">Menú</a>
    </body>
</html>
