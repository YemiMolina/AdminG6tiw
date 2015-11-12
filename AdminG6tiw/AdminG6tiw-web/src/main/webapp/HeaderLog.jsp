<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="es.uc3m.tiw.web.Usuario"%>

<%
		Usuario log = (Usuario)session.getAttribute("usuario");		
%>

  <body id="body" >

    <div id="header">
      <div class="row">
        <div class="col-lg-8 col-md-8 col-sm-7 col-xs-12">
          <figure>
            <a href="ServletLogin?accion=Index"><img id="imagenTitulo" src="./images/logo.png" alt="Logo tiw"></a>
          </figure>
          <h1 id="titulo">Dokulearning</h1>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-5 hidden-xs" style="float=right">
           <div id="registroUsuario">
           
              <div><p id="usuario"> <span style="color:white">Logged as: <%= log.getUsuario() %> </span> </p><p id="usuarioActual" ></p>
              <div  >
                <a  href="ServletLogin?accion=Salir"><input id="botonSubmit" type="submit" value="Cerrar Sesión"></a>
              </div>
            </div>
		
          </div>
        </div>
      </div>
    </div>

    <!--Menú con lista de enlaces-->

<div class="menu">
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Menu</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="ServletLogin?accion=Index">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="ServletLogin?accion=Perfil">Perfil</a></li>
        <li><a href="ServletCursos">Cursos</a></li>
        <li><a href="ServletLogin?accion=Perfiles">Personas</a></li>
      </ul>
     <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Busca Usuarios">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Busca Cursos">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sesion <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Cerrar Sesion</a></li>
            
            <li role="separator" class="divider"></li>
            <li><a href="#">Informacion</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  </nav>
</div>

    <nav id="menud">
      <!-- <a class="enlace5" href="#">Home</a> -->    
    </nav>

 </body>
 
 