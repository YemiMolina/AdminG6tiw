<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
     <%@ page import="es.uc3m.tiw.web.Usuario"%>
     
     <%@ page import="es.uc3m.tiw.web.ServletSession"%>
    <%@ page import="javax.servlet.ServletException"%>
    <%@ page import="javax.servlet.annotation.WebServlet"%>
    <%@ page import="javax.servlet.http.HttpServlet"%>
    <%@ page import="javax.servlet.http.HttpServletRequest"%>
    <%@ page import="javax.servlet.http.HttpServletResponse"%>
    <%@ page import="javax.servlet.http.HttpSession"%>
    
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

  <title>Catalogo de cursos</title>
  <meta name="Alex" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg"> 


  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
   <link rel="stylesheet" type="text/css" href="./style/styleFondoBlanco.css">
    <link rel="stylesheet" type="text/css" href="./style/styleSimulacion.css">
    
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="./script/scriptHome.js"></script>
  <script type="text/javascript" src="./script/scriptSimulacion.js"></script>

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
	
<div id="busqueda">
    <br><p>Se han encontrado los siguientes resultados</p>
  <div class="row">
    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
    <div id="parametros">
      <br><h3 class="titulosPar">Configuración</h3>
      <h4 class="titulosPar">Tipo de dificultad</h4>
      <p class="datosPar">Basico</p>
      <input class="check" type="checkbox" id="basico" name="Basico" value="Basico" onchange="check()" checked>
      <p class="datosPar">Avanzado</p>
      <input class="check" type="checkbox" id="avanzado" name="Avanzado" value="Avanzado" onchange="check()" checked><br>
      <h4 class="titulosPar">Duracion</h4>
      <p class="datosPar">Corta</p>
      <input class="check" type="checkbox" id="corta" name="Corta" value="Corta" onchange="check()" checked>
      <p class="datosPar">Larga</p>
      <input class="check" type="checkbox" id="larga" name="Larga" value="Larga" onchange="check()" checked><br>
    </div>
    </div>
    
    <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">

<%
	ArrayList<Curso> Listacursos = (ArrayList<Curso>) request.getAttribute("Listacursos");
	//Iterator<Curso> iterador = null;
	int contador=0;
	for(Curso curso: Listacursos) {
		if(curso.getValidacion()== true){// voy a decir que los cursos que esten validados se imprimen aqui y los que no estan vlaidados no se van a poder imprimir
			
		
		%>
		<div id="fondoBlanco" style="margin: 5px">
		<li><%=curso.getTitulo() %> <br>
		<%=curso.getDescripcion() %> <br>
		<%=curso.getId() %> <br>
		El precio inicial es:<%=curso.getPrecio()%><br>
		El precio final es: <%=curso.getPrecioFinal()%> <br>
		Estado de validacion del curso: <%if(curso.getValidacion()== false){%>Pendiente de Validar <%}else{%> Curso Validado <%}%><br>
		Estado del curso como destacado: <%if(curso.getDestacado()== false){%>Curso no destacado <%}else{%> Curso Destacado <%}%><br>
		<br><br>

		 <img src="ServletImagenes?foto=<%=curso.getImagenuri()%>"> <br><br>
		 
		
		 
		 <a href="ServletLecciones?id=<%=curso.getId()%>" > Ver sus Lecciones </a></li><br>
		  <a href="CatalogoLecciones.jsp?id=<%=curso.getId()%>" > Añadir Leccion </a></li> <br>
		  <a href="Matriculacion.jsp?id=<%=curso.getId()%>&precioFinal=<%=curso.getPrecioFinal()%>" > Matricularse en este curso </a></li> <br>
		 <a href="ServletCursos?action=delete&id=<%=contador%>" >Eliminar curso </a></li>
		 <br>
		 <a href="Validar.jsp?id=<%=curso.getId()%>" > Ir al validador de curso </a></li><br>
		 <a href="Destacar.jsp?id=<%=curso.getId()%>" > Ir al interfaz de cursos destacados </a></li><br>
		 <a href="ListaComisiones.jsp?id=<%=curso.getId()%>" > Ir al interfaz de comisiones de los cursos </a></li><br>
		 	<a href="ServletCursos?action=modificar&id=<%=curso.getId()%>" > Modificar Curso </a></li><br>
		</div>
		<%contador++; %>
		<%
		
		
		}// fin del if de validacion
		else {// se supone que no va a salir ningun true aqui por lo q el curso no ha sido validado
			%>
			<div id="fondoBlanco" style="margin: 5px">
			<li>El curso <%=curso.getTitulo() %> no ha sido validado, por favor seleccione la opcion de validar si desea ver el curso <br>
				<%//curso.getId() %> <br>
			 <a href="ServletLecciones?id=<%=curso.getId()%>" > Ver sus Lecciones </a></li><br>
		 	 <a href="CatalogoLecciones.jsp?id=<%=curso.getId()%>" > Añadir Leccion </a></li> <br>
		 	 <a href="Matriculacion.jsp?id=<%=curso.getId()%>&precioFinal=<%=curso.getPrecioFinal()%>" > Matricularse en este curso </a></li> <br>
			 <a href="ServletCursos?action=delete&id=<%=contador%>" >Eliminar curso </a></li>
			 <br>
			 <a href="Validar.jsp?id=<%=curso.getId()%>" > Ir al validador de curso </a></li><br>
			 <a href="Destacar.jsp?id=<%=curso.getId()%>" > Ir al interfaz de cursos destacados </a></li><br>
			  <a href="ListaComisiones.jsp?id=<%=curso.getId()%>" > Ir al interfaz de comisiones de los cursos </a></li><br>
			  	<a href="ServletCursos?action=modificar&id=<%=curso.getId()%>" > Modificar Curso </a></li><br>
			</div>
			<%
			contador++;// esto esta en el de arriba supongo que tendra que ir aqui igual
		}
	}// fin del for de listado
	
		%>
</div>



<%@include file="Footer.jsp"%>	
</body>
</html>