<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.daos.CursoDao"%>
    <%@ page import="es.uc3m.tiw.model.daos.ICurso"%>
    <%@ page import="es.uc3m.tiw.model.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.PersistenceServletCursos"%>
    
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
	<form name="formulario" method="get" class="form-horizontal mitad"
		action="PersistenceServletCursos" >
		<hr>
		<fieldset>
		
		<div class="container">
			<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">
					<h4>Informaci&oacute;n sobre los cursos validados</h4>
					<% 
					 List<Curso> Listacursos = (List<Curso>) request.getAttribute("Listacursos");
				   	 String idcurso=(String)request.getAttribute("idcursos");
				   	 Integer id= Integer.valueOf(idcurso);
				    int contador=0;
				    for(Curso curso: Listacursos) {
				    	if	(curso.getIdcursos().equals(id)){
				    		
				    	
				    
				      
					/*PersistenceServletCursos sacarCurso= new PersistenceServletCursos();
					List <Curso> Listacursos =sacarCurso.getListaCursos();
					int contador=0;
					for(Curso curso: Listacursos) {*/
						%>
					<!-- 	<li><%//=curso.getTitulo() %> _____ <%=curso.getValidacion() %> <br>  -->
						<tr> <!-- &nbsp; esto sirve para meter un espacio  tambien aprovecho para meter la minicopmaracion para mostrar si esta validado o no-->
								<td><%=curso.getTitulo() %></td>   <td><%if(curso.getValidacion()== false){%>Pendiente de Validar <%}else{%> Curso Validado <%}%></td> <td><%//=curso.getImagenuri() %></td>
						</tr>
						<br>
						Estado de validacion
						
						
						 <br>
						<%Integer valor=curso.getIdcursos(); %>
						
						<%if(curso.getValidacion()==false){// si esto no se cumple es que es verdadderos entonces no necesatias validarlo otra vez %>
						<br/> <br/> ¿Deseas validar este curso?:<br/> <!-- paso el titulo de los cursos que voy a validar -->
							
						<a href="PersistenceServletCursos?action=cursoValidar&id=<%=curso.getIdcursos()%>" >  Validar este curso </a></li><br>					
						<%} // fin del if de validar cursos igual a false, 
						else if (curso.getValidacion()==true){%>
							<p>Este curso ya esta validado</p>
							<!--  <input  type="checkbox" name="entornos" value= <%=valor%> checked ><label for='chk_email_alerts'>Validar curso </label> <br/> -->
						<% }
						%>						
						<br>
						<p>--------------------------------</p>
						
						
					<%
					
					}// fin del if
					}// findel for
					%>
					
								
					<br>
					
					
					
					<br>
					<br>
					<% Curso curso= new Curso(); %>
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