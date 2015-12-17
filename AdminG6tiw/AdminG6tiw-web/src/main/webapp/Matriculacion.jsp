<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.Vale"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
    <%@ page import="es.uc3m.tiw.web.ServletPago"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pago del curso para matricularse</title>
</head>
<body>
    
    <%int idCursoActual = Integer.parseInt(request.getParameter("id"));%>
   <%double precio =  (Double)request.getAttribute("precio");%>
   <%double precioFinal =  (Double)request.getAttribute("precioFinal");%>
   <% Object idUsuario1 = request.getAttribute("idUsuario");
   Object idProfesor1 = request.getAttribute("idProfesor");
   int idProfesor=(Integer)idProfesor1;
   int idUsuario=(Integer)idUsuario1;
   //Integer.parseInt(idUsuario);%>
    
  
    <%List<Curso> CursosMatriculados = (List<Curso>)request.getAttribute("CursosMatriculados");
    List<Vale> ListaValesFinal = (List<Vale>)request.getAttribute("ListaValesFinal");
  %>
  
   <form action="ServletPago"  method="post"> 
    <% for(Vale vale: ListaValesFinal) {%>
    <li>  <input type="radio" name="vale" value="<%=vale.getCantidad() %>"  />Codigo del decuento<%=vale.getCodigo() %><br>
    Cantidad del descuento<%=vale.getCantidad() %> <br>
    Fecha de caducidad del descuento:<%=vale.getFechaCaducidad() %><br><br>
  
     <input type="hidden" name="precio" value="<%=precio %>"/>
    </li>
   <%  } 
    %>
 <br> <br> <br>
    El precio del curso es :
     <%= precio %> <br> <br>
	El precio final del curso con el descuento es :
	<%= precioFinal %>
    <br>
    
    <br><br>
    <input type="hidden" name="idProfesor" value="<%=idProfesor %>"/>
    <input type="hidden" name="idUsuario" value="<%=idUsuario %>"/><!-- este es el id del pagador, se le podria haber puesto un nombre mas adecuado -->
     <input type="hidden" name="idCurso" value="<%=idCursoActual %>"/>
     <input type="hidden" name="precio" value="<%=precio %>"/>
      <input type="submit" value="Aplicar el descuento">
    </form>

    
    
</body>
</html>