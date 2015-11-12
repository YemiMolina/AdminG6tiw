<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
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

  <title>Dokulearning | Home</title>
  <meta name="Alex" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg"> 


  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
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
	
   <div class="row">
    <div class="col-xs-12 col-sm-6">
        <div id="cursos">
      <a href="#">
        <a href="ServletCursos"><img src="./images/cursos.png" alt="" style="width:100%"></a>
      </a>
      <!-- <figcaption id="figcaption">Encuentra un curso a tu medida, empieza a buscar</figcaption> -->
    </div>
    </div>

    <!--Div que te lleva a tu perfil-->
    <div class="col-xs-12 col-sm-6">
    <div id="perfil">
      <!-- <figure onmouseover="mostrar('figcaption2')" onmouseout="ocultar('figcaption2')" onclick="permitir('perfil')"> -->
      <a href="#">
        <a href="ServletLogin?accion=Perfil"><img src="./images/perfil.png" alt="" style="width:100%"></a>
      </a>
    </div>
  </div>
</div>

    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="padding: 5px; height: 100%">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="row">
  <div class="col-xs-12 col-sm-6 col-sm-offset-3" style="margin-top: 10px; margin-bottom: 10px">
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <a href="ServletCursos"><img src="./images/curso_ingles.png" alt="" style="width:100%"></a>
          <div class="carousel-caption">
            ...
          </div>
        </div>
        <div class="item">
          <a href="ServletCursos"><img src="./images/curso_html.png" alt="..." style="width:100%"></a>
          <div class="carousel-caption">
            ...
          </div>
        </div>
        <div class="item">
          <a href="ServletCursos"><img src="./images/curso_foto.png" alt="..." style="width:100%"></a>
          <div class="carousel-caption">
            ...
          </div>
        </div>
      </div>
  </div>
</div>

      <!-- Controls -->
      <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>



    <!--Pie de página-->
	<%@include file="Footer.jsp"%>
    </body>
    </html>
