<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
   <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.daos.CursoDao"%>
    <%@ page import="es.uc3m.tiw.model.daos.ICurso"%>
    <%@ page import="es.uc3m.tiw.web.Usuario"%>
     
     <%@ page import="es.uc3m.tiw.model.Promocion"%>
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
	
	<div id="fondoBlanco" ><!-- cambio aqui lo que estaba de PersistenceServletCursos por PersistenceServletPromociones -->
	<form action="PersistenceServletPromociones" enctype="multipart/form-data" method="post">
		<legend> Contenido de las promociones de cursos  </legend>
		
		<div class="container">
			<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">
				<h4>Informaci&oacute;n sobre las pormociones de los cursos </h4>
				
				<% List<Promocion> Listacursos = (List<Promocion>) request.getAttribute("ListaPromocion");// esto es la lista de promociones no de cursos pero paso d ecmabiar el nombre 
			   	 String idcurso=(String)request.getAttribute("idcursos");
			   	 Integer id= Integer.valueOf(idcurso);
			   	 int numPromociones=Listacursos.size();
			    
				
					if	(numPromociones==0){%>
						<p>Recuerda que una vez creada la promoci&oacute;n no se puede modificar, solo borrar </p>
						<p> tiene prevalencia la promoción sobre el cupón</p>
							<p>No existe ninguna promocion, puedes crear ahora una</p><br>
							 <p> -Indica el descuento con un numero de 0 a 100: <input type="number" name="descuento"></p> <br>
							<br>
							 <p> -Indica la fecha de caducidad con el siguiente formato DD/MM/AAAA :  <input type="text" name="fecha"></p> <br>
							 <br>
							 <input type="submit" value="Crear">
							 <br>
							 <a href="PersistenceServletCursos?action=listarCursos" > Volver al listado  de cursos </a></li> <br>
						
					<br>
						
						
							
							<% }else {%>
								<p>Existe alguna promocion,</p><br>
								<% for(Promocion promo: Listacursos) {%>
									<p>Tienes las siguientes pormociones</p><br>
									<p>ID pormociones  <%=promo.getIdPromocion() %></p><br>
									<p>Con fecha de caducidad   <%=promo.getFecha() %></p><br>
									<p>Con cantidad  <%=promo.getCantidad() %></p><br>
									
									<p>Puedes crear otra si deseas. Recuerda que una vez creada la promoci&oacute;n no se puede modificar, solo borrar </p>
						<p> tiene prevalencia la promoción sobre el cupón</p>
							<p>No existe ninguna promocion, puedes crear ahora una</p><br>
							 <p> -Indica el descuento con un numero de 0 a 100: <input type="number" name="descuento"></p> <br>
							<br>
							 <p> -Indica la fecha de caducidad con el siguiente formato DD/MM/AAAA :  <input type="text" name="fecha"></p> <br>
							 <br>
							 <input type="submit" value="Crear">
									
									<a href="PersistenceServletCursos?action=listarCursos" > Volver al listado  de cursos </a></li> <br>
									<a href="PersistenceServletCursos?action=borrarPromocion&id=<%=promo.getIdPromocion()%>" > borrar promocion en este curso </a></li> <br>
								<% }// fin for%>
							<% }
							%>
						
						
						
						
						
						
						
						
						
						
					<%
				
				
				%>
				
				
				</div>
			</div>
		</div>
	
	</div>
<!-- this here is considered a banger   beware of strangers  -->
</body>
<%/* El	administrador,	sobre	el	30%	del	beneficio	de	un	curso	o	conjunto	de	cursos	podrá	definir	promociones,	
que	serán	descuentos	aplicables	a	un	curso.	
Los	cursos	sujetos	a	promociones	serán	visibles	en	los	cursos	expuestos	en	la	Web.*/ %>
</html>