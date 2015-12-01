<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

  <!-- Jquery para cargar los scripts de bootstrap --> 
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <title>LearnIt | Home</title>
  <meta name="Author" content="Grupo de practicas TIW" lang="es">
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
	<%@include file="Header.jsp"%> 

<div id="fondoBlanco" >
<p> <strong>Formulario para dar de alta los cursos a la plataforma Dokulearning</strong></p>
<form action="/usuario" enctype="multipart/form-data" method="post">
    <hr>
    <fieldset>
    <legend> Alta de curso 
    </legend>
    
	<p> -Título: <input type="text" name="titulo"/></p>
    <br><br>
	
	<p> -Descripción:
    <textarea name="descripcion" rows="2" cols="30">
   
    </textarea> </p>
    <br><br>
	
    <p> -Nivel de dificultad:
        <br>
        <input type="radio" name="dificultad" value="basico"  /> Básico
        <br>
        <input type="radio" name="dificultad" value="intermedio"  /> Intermedio
        <br>
        <input type="radio" name="dificultad" value="avanzado"  /> Avanzado
        </p>
    <br><br>

    <p> -Número de horas: <input type="number" name="numeroh"> </p>
    <br>
    
    <p> -Precio: <input type="number" name="precio"></p> <br>
    
    <p> -Tipos de Descuentos : 
     <br>
        <input type="radio" name="descuento" value="fijo"  /> 10 euros
        <br>
        <input type="radio" name="descuento" value="variable"  /> 10% de descuento
        <br>
        <input type="radio" name="descuento" value="ninguno"  /> Ningun descuento
        <br>
    
	
	<p> Subir Imagen</p>
	
		<input type="hidden" name="action" value="upload">
	 <p>
			<input type="file" name="imagenuri">
		</p> 
		
    <input type="submit" value="Dar de alta">
</form>
</div>
 
 <%@include file="Footer.jsp"%>

</body>
</html>