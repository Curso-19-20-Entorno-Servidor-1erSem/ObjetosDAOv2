<%-- 
    Document   : error
    Created on : 8 nov. 2019, 17:28:04
    Author     : franciscoantonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/avesStyle.css">
        <%@include file="/INC/metas.inc"%>
        <title>Error......</title>
    </head>
    <body>
         <c:set var="error" value='${requestScope.error}'/>
        <h1>ERROR: </h1><p>${error}</p>
    </body>
</html>
