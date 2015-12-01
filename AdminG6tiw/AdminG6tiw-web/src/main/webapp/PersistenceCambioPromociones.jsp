<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.ServletCursos"%>
<!DOCTYPE html >
   
<html>
<!--Head contenedor del título de la página, enlaces a las stylesheets, tipografías y charset-->
<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

  <!-- Jquery para cargar los scripts de bootstrap --> 
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <title>Cursos destacados</title>
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

<body>
  <!--Header-->
  	<%if (session.getAttribute("usuario") != null) { %>
 	<jsp:include page="HeaderLog.jsp"/>
	<%}else{%>
	<jsp:include page="Header.jsp"/>
	<% } %>
	
	<div id="fondoBlanco" >
	<form name="formulario" action="ListaDestacados.jsp" class="form-horizontal mitad"
		method="post">
		<hr>
		<fieldset>
			
			

			<legend> Se han efectuado los cambios </legend>

			

			
		<div class="container">
			<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">
					<h4>Pulse para volver al listado de cursos</h4>
					
					
						<br>
						
						
						
						
								
					<br>
					
					
					
					<br>
					<br>
					
					<a href="PersistenceServletCursos" > Ir al listado de cursos </a></li><br>
				
				</div>
			
			
			</div>
		</div>
		
	</form>	
			</fieldset>
	</form>
</div>
    <!--Pie de página-->
	<%@include file="Footer.jsp"%>

</body>
</html>