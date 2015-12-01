<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
     <%@ page import="es.uc3m.tiw.model.Leccion"%>
      <%@ page import="es.uc3m.tiw.model.Curso"%>
      <%@ page import="es.uc3m.tiw.model.daos.CursoDao"%>
      <%@ page import="es.uc3m.tiw.model.daos.ICurso"%>
      <%@ page import="es.uc3m.tiw.model.Persona"%>
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

  <title>lista de cursos buscados</title>
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
			
			

			<legend> Lista de cursos encontrados </legend>

			

			
		<div class="container">
			<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">
					<h4> listado de cursos</h4>
					<%
						List<Curso> Listacursos = (List<Curso>) request.getAttribute("Listacursos");
						System.out.println("el numero de cursos en lista es "+Listacursos.size());%>
						<%for(Curso curso: Listacursos) {
							if(curso.getValidacion()== true){// voy a decir que los cursos que esten validados se imprimen aqui y los que no estan vlaidados no se van a poder imprimir
								
								
								%>
								<div id="fondoBlanco" style="margin: 5px">
								<li><%=curso.getTitulo() %> <br>
								<%=curso.getDescripcion() %> <br>
								<%=curso.getIdcursos()%> <br>
								El precio inicial es:<%=curso.getPrecio()%><br>
								El precio final es: <%=curso.getPrecioFinal()%> <br>
								Estado de validacion del curso: <%if(curso.getValidacion()== false){%>Pendiente de Validar <%}else{%> Curso Validado <%}%><br>
								Estado del curso como destacado: <%if(curso.getDestacado()== false){%>Curso no destacado <%}else{%> Curso Destacado <%}%><br>
								<br><br>

								 <img src="ServletImagenes?foto=<%=curso.getImagenuri()%>"> <br><br>
								 
								
								 
								 <a href="ServletLecciones?id=<%=curso.getIdcursos()%>" > Ver sus Lecciones </a></li><br>
								  <a href="CatalogoLecciones.jsp?id=<%=curso.getIdcursos()%>" > Añadir Leccion </a></li> <br>
								  <a href="Matriculacion.jsp?id=<%=curso.getIdcursos()%>&precioFinal=<%=curso.getPrecioFinal()%>" > Matricularse en este curso </a></li> <br>
								 <a href="ServletCursos?action=delete&id=<%=curso.getIdcursos()%>" >Eliminar curso </a></li>
								 <br>
								 <a href="PersistenceServletCursos?action=validar&id=<%=curso.getIdcursos()%>" > Ir al validador de curso </a></li><br>
								 <a href="PersistenceServletCursos?action=destacar&id=<%=curso.getIdcursos()%>" > Ir al interfaz de cursos destacados </a></li><br>
								 <a href="ListaComisiones.jsp?id=<%=curso.getIdcursos()%>" > Ir al interfaz de comisiones de los cursos </a></li><br>
								 	<a href="PersistenceServletCursos?action=modificar&id=<%=curso.getIdcursos()%>" > Modificar Curso </a></li><br>
								 	<a href="PersistenceServletCursos?action=listarCursos" > servlet persistencia </a></li> <br>
								 	<a href="PersistenceServletCursos?action=listarCursos" > llamar al listado de persistencia de cursos </a></li> <br>
								 	<a href="PersistenceServletCursos?action=promocion&id=<%=curso.getIdcursos()%>" > crear o borrar promocion en este curso </a></li> <br>
								</div>
								
								<%
								
								
								}// fin del if de validacion
								else {// se supone que no va a salir ningun true aqui por lo q el curso no ha sido validado
									%>
									<div id="fondoBlanco" style="margin: 5px">
									<li>El curso <%=curso.getTitulo() %> no ha sido validado, por favor seleccione la opcion de validar si desea ver el curso <br>
										<%//curso.getId() %> <br>
									 <a href="ServletLecciones?id=<%=curso.getIdcursos()%>" > Ver sus Lecciones </a></li><br>
								 	 <a href="CatalogoLecciones.jsp?id=<%=curso.getIdcursos()%>" > Añadir Leccion </a></li> <br>
								 	 <a href="Matriculacion.jsp?id=<%=curso.getIdcursos()%>&precioFinal=<%=curso.getPrecioFinal()%>" > Matricularse en este curso </a></li> <br>
									 <a href="PersistenceServletCursos?action=delete&id=<%=curso.getIdcursos()%>" >Eliminar curso </a></li>
									 <br>
									 <a href="PersistenceServletCursos?action=validar&id=<%=curso.getIdcursos()%>" > Ir al validador de curso </a></li><br>
									 <a href="PersistenceServletCursos?action=destacar&id=<%=curso.getIdcursos()%>" > Ir al interfaz de cursos destacados </a></li><br>
									  <a href="ListaComisiones.jsp?id=<%=curso.getIdcursos()%>" > Ir al interfaz de comisiones de los cursos </a></li><br>
									  	<a href="PersistenceServletCursos?action=modificar&id=<%=curso.getIdcursos()%>" > Modificar Curso </a></li><br>
									  	<a href="ServletPromociones?id=<%=curso.getIdcursos()%>" > Añadir Promocion </a></li> <br>
									  	<a href="PersistenceServletCursos?action=listarCursos%>" > servlet persistencia </a></li> <br>
									  	<a href="PersistenceServletCursos?action=listarCursos" > llamar al listado de persistencia de cursos </a></li> <br>
									  	<a href="PersistenceServletCursos?action=promocion&id=<%=curso.getIdcursos()%>" > crear o borrar promocion en este curso </a></li> <br>
									</div>
									<%
									
								}
							}// fin del for de listado
						
						%>
						
					
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