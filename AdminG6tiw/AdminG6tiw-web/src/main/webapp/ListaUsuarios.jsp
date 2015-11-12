<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="es.uc3m.tiw.web.Usuario"%>
<%@ page import="es.uc3m.tiw.web.ServletRegistroUsuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de usuarios</title>
</head>
<body>


<ul>
<p> Holaaa</p>


				<%
				

		ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>)request.getAttribute("listaUsuarios");
				
						int contador=0;
						 for(Usuario us1: listaUsuarios) {
			%>
				<li><p>Nombre:<%=us1.getNombre() %></p>
       				<p>Apellidos:<%=us1.getApellidos() %></p>
				
				</li>
				<p>Borrar usuario </p>
				

				

				<%
					contador++;
				%>
				<%
					}
					
				%>
				

			</ul>






</body>
</html>