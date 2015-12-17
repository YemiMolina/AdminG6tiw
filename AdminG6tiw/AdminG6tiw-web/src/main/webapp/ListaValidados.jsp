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

  <title>Catalogo de lecciones</title>
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
		
		<h1>Estas en la lista de validados</h1>

	<ul>
	<%
	String []seleccionados = request.getParameterValues("entornos");
	if(seleccionados!=null){//si no hay nada no puedes recorrer asi q no entras
		for(int i=0; i<seleccionados.length;i++ ){// recorro solo aquellos q valido
			%>
			<li><!-- esto es opcional este print se puede quitar lo dejo solo para controlar -->
			<%=seleccionados[i] %>
			</li>
			
			<% 
		}//fin for
	}//fin if
	//zona M.O.P
	%>
	</ul>
	<ul>
	<%
	ServletCursos sacarCurso= new ServletCursos();
	ArrayList <Curso> Listacursos =sacarCurso.getListaCursos();
	int contador=0;
	if(seleccionados!=null){// la lista de seleccionados 
		for(Curso curso: Listacursos) {// recorro la lista de cursos
	
			for (int k=0; k<seleccionados.length; k++){
				if (curso.getTitulo().equalsIgnoreCase(seleccionados[k])){// si los titulos conciden es xq es verdadero
					curso.setValidacion(true);//digo q es verdadero
				}
			}// fin  for de seleccionados en validar.jsp
			
		}// fin for
	}// fin if
	
		for(Curso curso: Listacursos){// recorro solo aquellos q valido
			%>
			
			<li>
				<tr> <!-- &nbsp; esto sirve para meter un espacio  tambien aprovecho para meter la minicopmaracion para mostrar si esta validado o no-->
									<td><%=curso.getTitulo() %></td>   <td><%if(curso.getValidacion()== false){%>Pendiente de Validar <%}else{%> Curso Validado <%}%></td> <td><%//=curso.getImagenuri() %></td>
				</tr>
			</li>
			<% 
		}//fin for
	
	
	
	
	%>
	<a href="Validar.jsp" >Volver a la lista de validaciones </a>
	</ul>	
			
			
			
			</fieldset>
	
</div>
    <!--Pie de página-->
	<%@include file="Footer.jsp"%>

</body>
</html>