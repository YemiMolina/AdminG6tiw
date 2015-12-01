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
	<form action="PersistenceServletCursos" enctype="multipart/form-data" method="post">
		<legend> Contenido de las promociones de cursos  </legend>
		
		<div class="container">
			<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">
				<h4>Informaci&oacute;n sobre las pormociones de los cursos </h4>
				
				<% List<Curso> Listacursos = (List<Curso>) request.getAttribute("Listacursos");
			   	 String idcurso=(String)request.getAttribute("idcursos");
			   	 Integer id= Integer.valueOf(idcurso);
			    
				for(Curso curso: Listacursos) {
					if	(curso.getIdcursos().equals(id)){%>
						<p>Recuerda que una vez creada la promoci&oacute;n no se puede modificar, solo borrar </p>
						<p> tiene prevalencia la promoción sobre el cupón</p>
						
						
					<br>
						<p>El precio actual del curso es: <%=curso.getPrecio() %> </p><br>
						<%if(curso.getDescuentoPromocion()==0){// si es 0 es que no hay promocion xa ese curspo
							System.out.println("eestoy dentro del if para la promocion de cursos dando la promocion al curso "+curso.getIdcursos());
							%>
							<p>No existe ninguna promocion, puedes crear ahora una</p><br>
							 <p> -Indica el descuento con un numero de 0 a 100: <input type="number" name="descuento"></p> <br>
							
							 <br>
							  <input type="text" name="id" value=<%=curso.getIdcursos() %> readonly="readonly" />
							
							 <input type="text" name="promocion" value="promocion" readonly="readonly" />
							 <br>
								<a href="PersistenceServletCursos?action=crearPromocion&id=<%=curso.getIdcursos()%>&descuento= descuento" > Volver al listado  de cursos </a></li> <br>
							<input type="submit" value="Dar de alta">
								
							<br>
							
							<% }else {%>
								<p>Existe una promocion,</p><br>
								<a href="PersistenceServletCursos?action=listarCursos" > Volver al listado  de cursos </a></li> <br>
								<a href="PersistenceServletCursos?action=borrarPromocion&id=<%=curso.getIdcursos()%>" > borrar promocion en este curso </a></li> <br>
								
							<% }
							%>
						
						
						
						
						
						
						
						
						
						
					<%}// fin if de igualacion id
				}// fin for
				
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