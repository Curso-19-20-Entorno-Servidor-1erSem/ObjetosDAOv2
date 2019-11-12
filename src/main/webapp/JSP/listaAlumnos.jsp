<%-- 
    Document   : listaAlumnos
    Created on : 8 nov. 2019, 17:29:47
    Author     : franciscoantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/INC/metas.inc"%>
        <title>Listado Alumnos.</title>
    </head>
    <body>
        <h1>Alumnos: </h1>
        <p>Nombre y Grupo</p>
        <c:forEach var="alumno" items="${alumnos}">
            Nombre: ${alumno.nombre} | Grupo: ${alumno.grupo}</br>
        </c:forEach>

        <br><br>
        <c:url var="index" value="/index.jsp"/>
        <a href="${index}">Menú</a>
    </body>
</html>
