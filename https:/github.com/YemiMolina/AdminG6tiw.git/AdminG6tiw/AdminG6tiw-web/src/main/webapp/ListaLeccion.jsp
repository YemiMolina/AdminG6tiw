<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.ServletCursos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

  <!-- Jquery para cargar los scripts de bootstrap --> 
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <title>Lecciones</title>
  <meta name="Alex" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg"> 


  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
  <link rel="stylesheet" type="text/css" href="./style/styleFondoBlanco.css">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="./script/scriptHome.js"></script>

  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
  <META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8"/>
</head>

<jsp:include page="HeaderLog.jsp"/>

<body id="body">

	<div id="fondoBlanco">
            <ul>
            <%
                String id = request.getParameter("id");
                System.out.println("que hay en id curos"+ id);
                Curso curso= ServletCursos.BuscarCurso(Integer.parseInt(id));
                if(curso.getListaLecciones()!=null){
                    ArrayList<Leccion> ListaLecciones2 =curso.getListaLecciones();
                    int contador = 0;
                    for (Leccion leccion : ListaLecciones2) {
                        System.out.println("que hay en identificador de leccion"+ leccion.getIdentificador());
                        contador=leccion.getIdentificador();
            %>
            
                <li> <td><%=leccion.getDescripcion()%> </td> <br>
                <a href="ServletImagenes?foto=<%=leccion.getMaterial() %>">Material de la leccion</a> <br><br>
                <li>
                <a href="ServletLecciones?action=delete&id=<%=contador%>&curso=<%=id %>" >Eliminar leccion </a></li> 
                 <a href="ServletLecciones?action=deleteL&id=<%=contador%>&curso=<%=id%>" >Eliminar Material </a></li> 
            
            <% 
                        contador++;
                    }// fin for recorrer lista lecciones2
            }// fin del if de lista vacia
            %>
            
            
                

            </ul>
            <a href="ServletCursos?id=<%=request.getParameter("id")%>">
                    Ir al listado de Cursos </a>
       </div>       
           <!--Pie de página-->
	<%@include file="Footer.jsp"%>
</body>
</html>