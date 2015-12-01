<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.ServletCursos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificacion</title>
</head>
<body>

<form action="ServletCursos" enctype="multipart/form-data" method="post">
   
    <hr>
    <fieldset>
    <legend> Alta de curso 
    </legend>
    
    <% Curso CursoModificar =(Curso) request.getAttribute("CursoModificar");%>
    <input type="hidden" name="id" value="<%=CursoModificar.getId() %>">
	<p> -Título: <input type="text" name="titulo" value="<%=CursoModificar.getTitulo() %>"/></p>
    <br><br>
	
	<p> -Descripción:
    <input type="text" name="descripcion" value="<%=CursoModificar.getDescripcion() %>" />
   
     </p>
    <br><br>
	
    <p> -Nivel de dificultad:
        <br>
        <input type="radio" name="dificultad" value="<%=CursoModificar.getDificultad() %>"  /> Básico
        <br>
        <input type="radio" name="dificultad" value="<%=CursoModificar.getDificultad() %>"  /> Intermedio
        <br>
        <input type="radio" name="dificultad" value="<%=CursoModificar.getDificultad() %>"  /> Avanzado
        </p>
    <br><br>

    <p> -Número de horas: <input type="number" name="numeroh" value="<%=CursoModificar.getNumeroh() %>"> </p>
    <br>
    
    <p> -Precio: <input type="number" name="precio" value="<%=CursoModificar.getPrecio() %>"></p> <br>
    
    <p> -Cupon Descuento (si se desea): 
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

</body>
</html>