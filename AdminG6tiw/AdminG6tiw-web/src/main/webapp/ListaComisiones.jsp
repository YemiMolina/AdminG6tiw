<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.ServletCursos"%>
    <%@ page import="es.uc3m.tiw.web.Usuario"%>
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
	<form name="formulario" action="ListaDestacados.jsp" class="form-horizontal mitad"
		method="post">
		<hr>
		<fieldset>
		
			<%
				String id = request.getParameter("id");
			%>
			<input type="hidden" name="id" value="<%=id%>" />

			<legend> Contenido de las comisiones de cursos </legend>

		

			
		<div class="container">
			<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">
					<h4>Informaci&oacute;n sobre las comisiones de los cursos </h4>
					
					<%System.out.println("que hay en id curos "+ id);
					Curso curso= ServletCursos.BuscarCurso(Integer.parseInt(id));
					double profe=1- curso.getComisionPortal();
					System.out.println("salida profe "+profe);
					
					%>
					
					
					<p>las comisiones del curso con titulo  <%=curso.getTitulo()  %>
					<p>la comisi&oacute;n del portal curso <%=curso.getComisionPortal()  %>
					<p>la comisi&oacute;n del profesor curso <%=profe  %> </p> </br>
					
					------------------------------------
					
					<%if (curso.getListaUsuario().size()<=0){
						System.out.println("No hay nadie inscrito ");%>
						<p> no hay nadie inscrito</p>
						<p>lista tamaño <%=curso.getListaUsuario().size() %></p>
					<% }else if (curso.getListaUsuario().size()>0){// si hay alguno te metes
						System.out.println(" inscrito en el curso hay  "+curso.getListaUsuario().size());
						ArrayList<Usuario> ListaUsuarios=curso.getListaUsuario();
						/*Calendar calendario = new GregorianCalendar();
						int hora =calendario.get(Calendar.HOUR_OF_DAY);
						System.out.println("que tiempo vives"+ hora);*/
						System.out.println("antes del for "+curso.getListaUsuario().get(0));
						for (Usuario usuario : ListaUsuarios) {
							System.out.println("dentro del for "+usuario);
							String mat=usuario.getUsuario();
							System.out.println("dentro del for "+mat);
						%>
						<li> <td>Usuarios que estan matriculados en este curso <%=mat %></td>
							<li> <td><%//usuario.getUsuario%> </td>
							
						<% }//fin for
						
					}
					%>
					
					<!--  <p> El salario para el profesor es; </p>-->
					<%//curso.getSalarioProfesor() %>
					
					
										
						
					
								
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