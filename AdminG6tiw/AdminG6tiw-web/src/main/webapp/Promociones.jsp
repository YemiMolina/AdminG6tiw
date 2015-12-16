<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.ServletCursos"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
     
    <%@ page import="es.uc3m.tiw.web.Promocion"%>
    <%@ page import="es.uc3m.tiw.web.ServletPromociones"%>
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

  <title>Lista comisiones</title>
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
	
		<hr>
		<fieldset>
		
			<%
				String id = request.getParameter("id");
			%>
			<input type="hidden" name="id" value="<%=id%>" />

			<legend> Contenido de las promociones de cursos </legend>
			
			

		

			
		<div class="container">
			<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">
					<h4>Informaci&oacute;n sobre las Promociones de los cursos </h4>
					
					
												<body>
							<% List<Promocion> listaPromocion =(ArrayList<Promocion>)request.getAttribute("ListaPromociones"); %>
							<%  for (Promocion promociones : listaPromocion){%>
							    Nombre <%=promociones.getNombre() %> <br>
							    Tipo de descuento (en euros) <%=promociones.getDescuento() %> <br>
							 
							     <a href="ServletPromociones?id=<%=promociones.getId()%>&action=delete"> Borrar promocion </a>
							 <% }%>
							
							
							<form action="ServletPromociones" method="post">
							<div>
							<p> -Nombre de la promocion:  <input type="text" name="nombre"/></p>
							    <br><br>
							
							<p> -Descuento (en euros):   <input type="number" name="descuento"> </p>
							    <br>
							    
							    <input type="submit" value="Crear nueva promocion">
							   
							    </div>
							    
							    
							    
							</form>
							</body>
				
					
					
										
						
					
								
					<br>
					
					<a href="ServletCursos?id=<%=request.getParameter("id")%>">
					Ir al listado de Cursos </a>
					
					
				
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