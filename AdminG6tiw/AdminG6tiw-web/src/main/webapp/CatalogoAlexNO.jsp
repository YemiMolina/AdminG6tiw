<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
    
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
 
  <script type="text/javascript" src="./script/scriptSimulacion.js"></script>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="./script/scriptHome.js"></script>

  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
  <META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8"/>
</head>


  <body id="body" >
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
    
    
<!--     <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
    <div class="restoOfertas" id="oferta1">
      <h3 class="tituloOferta">Curso avanzado de HTML5 (Adolfo Muñoz: link al perfil)</h3>
      <p class="tituloDescripcion">Descripción:</p>
      <p class="descripcion">Curso avanzado de html5 en el que se perfeccionaran las tecnicas en la creacion de paginas web</p>
      <p class="duracion">Duracion: Corta</p>
      <p class="dificultad">Dificultad: Basico</p>
      <a href="./inscripciones.html" class="inscripcion">Inscribirme en este curso</a> 
    </div>

    <div class="restoOfertas" id="oferta2">
      <br><h3 class="tituloOferta">Curso de fotografia profesional</h3>
      <p class="tituloDescripcion">Descripción:</p>
      <P class="descripcion">Curso de fotografia profesional</P>
      <p class="duracion">Duracion: Corta</p>
      <p class="dificultad">Dificultad: Avanzado</p><br>
      <a href="./inscripciones.html" class="inscripcion">Inscribirme en este curso</a> 
    </div>

    <div class="restoOfertas" id="oferta3">
      <br><h3 class="tituloOferta">Curso de fotografia basico</h3><br>
      <p class="tituloDescripcion">Descripción:</p><br>
      <P class="descripcion">Curso de fotografia basico</P>
      <p class="duracion">Duracion: Corta</p>
      <p class="dificultad">Dificultad: Basico</p><br>
      <a href="./inscripciones.html" class="inscripcion">Inscribirme en este curso</a> 
    </div>

    <div class="restoOfertas" id="oferta4">
      <br><h3 class="tituloOferta">Curso Office avanzado</h3><br>
      <p class="tituloDescripcion">Descripción:</p><br>
      <P class="descripcion">Curso Office avanzado</P>
      <p class="duracion">Duracion: Larga</p>
      <p class="dificultad">Dificultad: Avanzado</p><br>
      <a href="./inscripciones.html" class="inscripcion">Inscribirme en este curso</a> 
    </div>
    <br><br>
  </div>
  </div>
    
  </div> -->
	<div id="fondoBlanco" >
<%
	ArrayList<Curso> Listacursos = (ArrayList<Curso>)request.getAttribute("Listacursos");
	//Iterator<Curso> iterador = null;
	int contador=0;
	for(Curso curso: Listacursos) {
		%>
		<div>
		<div class="restoOfertas" id="">
      <h3 class="tituloOferta"><%=curso.getTitulo() %></h3>
      <p class="tituloDescripcion">Descripción:</p>
      <p class="descripcion"><%=curso.getDescripcion() %></p>
      <p class="duracion">Duracion: Corta</p>
      <p class="dificultad">Dificultad: <%=curso.getDificultad() %></p>
      <a href="./inscripciones.html" class="inscripcion">Inscribirme en este curso</a> 
    
		<%=curso.getTitulo() %> <br>
		<%=curso.getDescripcion() %> <br>
		El precio inicial es:<%=curso.getPrecio()%><br>
		El precio final es: <%=curso.getPrecioFinal()%> <br>
		<br><br>

		 <img src="ServletImagenes?foto=<%=curso.getImagenuri()%>"> <br><br>
		 
		 <a href="ServletLecciones?id=<%=curso.getId()%>" > Ver sus Lecciones </a></li><br>
		  <a href="CatalogoLecciones.jsp?id=<%=curso.getId()%>" > Añadir Leccion </a></li> <br>
		  <a href="Matriculacion.jsp?id=<%=curso.getId()%>&precioFinal=<%=curso.getPrecioFinal()%>" > Matricularse en este curso </a></li> <br>
		  <a href="ServletCursos?action=modificar&id=<%=curso.getId()%>" > Modificar Curso </a></li><br>
		 <a href="ServletCursos?action=delete&id=<%=contador%>" >Eliminar curso </a></li>
		</div>
		</div>
		<%contador++; %>
		<%
	}
	
		%>
	
		<br>
<a href="FormularioAlta.jsp" >Dar de alta otro curso </a>	
</div>

<%@include file="Footer.jsp"%>	
</body>
</html>