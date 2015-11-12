<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
     <%@ page import="es.uc3m.tiw.web.Usuario"%>
      <%@ page import="es.uc3m.tiw.web.ServletPago"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
    <%Boolean exitoMatriculado = (Boolean)(request.getAttribute("ExitoAniadir"));%>
    <% if(exitoMatriculado==false){%>
       
        <p>Ya esta matriculado en este curso, no puede volver a matricularse </p>
     
       
    <%}else{%>
        <p>Has sido matriculado </p>
   
    <%}%>  

    <a href="ServletMisCursos?id=<%=request.getParameter("id")%>">  Ir al perfil </a><br>
        
</body>
</html>