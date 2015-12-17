<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
  <meta name="Author" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg"> 

  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
  
  <META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8"/>
  
  <link rel="stylesheet" type="text/css" href="./style/styleSimulacion.css">
  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
  <script type="text/javascript" src="./script/scriptSimulacion.js"></script>
  <!--Header-->


  <body id="body" onload="usuarioActual()" >

    <header id="header">
      <div class="row">
        <div class="col-lg-8 col-md-8 col-sm-7 col-xs-12">
          <figure>
            <a href="../src/index.html"><img id="imagenTitulo" src="./images/logo.png" alt="Logo tiw"></a>
          </figure>
          <h1 id="titulo">Bienvenido</h1>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-5 hidden-xs" style="float=right">
          <div id="registroUsuario">
            <form name="formularioUsuario"  method="post" onsubmit="return checkUsuario()" action="../src/perfil.html">
              <div><p id="usuario"> <span style="color:white">Usuario </span></p> <input class="cuadro"  id="cuadro" type="text" name="user"></input></div>
              <div style="clear: both; float: left"><p id="pas"><span style="color:white"> Contraseña </span></p> <input class="cuadro" id="cuadro"  type="password" name="pasw"></input></div>
            </form>
            <div id="registroUsuario">
              <input id="botonSubmit" type="submit" value="Iniciar Sesión">
              <a class="enlaceUsuario" href="../src/formUsuarioRegistro.html" style="font-size:20px;" >¿Aún no te has registrado?</a>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!--Menú con lista de enlaces-->

<div id="menu">
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
        <li ><a href="#">Home</a> </a></li>
        <li class="active"><a href="#">Cursos <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Perfil</a></li>
      </ul>
     <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sesion <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <input type="text" class="form-control" placeholder="Usuario">
            <input type="text" class="form-control" placeholder="Contraseña">
            <li><a href="#">Iniciar Sesion</a></li>
            <li><a href="#">Cerrar Sesion</a></li>
            <li><a href="#">Resgistrarse</a></li>
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
      <a class="enlace5" href="#">Home  >  Cursos</a>    
    </nav>



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
    <div class="restoOfertas" id="oferta1">
      <br><h3 class="tituloOferta">Curso avanzado de HTML5 (Adolfo Muñoz: link al perfil)</h3><br>
      <p class="tituloDescripcion">Descripción:</p><br>
      <P class="descripcion">Curso avanzado de html5 en el que se perfeccionaran las tecnicas en la creacion de paginas web"</P>
      <p class="duracion">Duracion: Corta</p>
      <p class="dificultad">Dificultad: Basico</p><br>
      <a href="./inscripciones.html" class="inscripcion">Inscribirme en este curso</a> 
    </div>

    <div class="restoOfertas" id="oferta2">
      <br><h3 class="tituloOferta">Curso de fotografia profesional</h3><br>
      <p class="tituloDescripcion">Descripción:</p><br>
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
    
  </div>

    <!--Pie de página-->
    <footer id="footer">  
      <div class="row">
        <div class="col-xs-12 col-sm-4">
          <div id="usuarios">
            <br><br>
            <h5>USUARIOS</h5>
            <br>
            <ul class="enlacesFinal">
              <li><a class="enlaceF" href="#" onclick="permitir('perfil')">mi perfil</a></li>
              <li><a class="enlaceF" href="#" onclick="permitir('cv')">mis cursos</a></li>
              <li><a class="enlaceF" href="../src/error.html">mis contactos</a></li>
            </ul>
          </div>
        </div>
        <div class="col-xs-12 col-sm-4">
          <div id ="empresas">
            <br><br>
            <h5>LEARNIT</h5>
            <br>
            <ul class="enlacesFinal">
              <li><a class="enlaceF" href="../src/error.html">profesores</a></li>
              <li><a class="enlaceF" href="../src/error.html">cursos</a></li>
              <li><a class="enlaceF" href="../src/error.html">informe de actividad</a></li>
            </ul>
          </div>
        </div>
        <div class="col-xs-12 col-sm-4">
          <div id="contacto">
            <br><br>
            <h5>CONTACTO</h5>
            <br>
            <ul class="enlacesFinal">
              <li><a class="enlaceF" href="../src/error.html">contacta con LearnIt</a></li>
              <li><a class="enlaceF" href="../src/error.html">información</a></li>
              <li><a class="enlaceF" href="../src/error.html">trabaja en LearnIt</a></li>
              </ul>
            </div>
          </div>
        </div>
<p>COPYRIGHT (C) 2015 LearnIt S.L. | TODOS LOS DERECHOS RESERVADOS. | Diseñado por  --------------------------</P>
      </footer>
    </body>
    </html>