<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.ServletCursos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lecciones</title>
</head>
<body>
			<ul>
			<%
				String id = request.getParameter("id");
				System.out.println("que hay en id curos"+ id);
				Curso curso= ServletCursos.BuscarCurso(Integer.parseInt(id));
				if(curso.getListaLecciones()!=null){
					ArrayList<Leccion> ListaLecciones2 =curso.getListaLecciones();
					int contador = 0;
					for (Leccion leccion : ListaLecciones2) {
						System.out.println("que hay en identificador de leccion"+ leccion.getIdentificador());
						contador=leccion.getIdentificador();
			%>
			
				<li> <td><%=leccion.getDescripcion()%> </td> <td><%=leccion.getMaterial()%> </td><br>
				<li>
				<a href="ServletLecciones?action=delete&id=<%=contador%>&curso=<%=id %>" >Eliminar leccion </a></li> 
				 <a href="ServletLecciones?action=deleteL&id=<%=contador%>&curso=<%=id%>" >Eliminar Material </a></li> 
			
			<% 
						contador++;
					}// fin for recorrer lista lecciones2
			}// fin del if de lista vacia
			%>
			
			
				

			</ul>
			<a href="ServletCursos?id=<%=request.getParameter("id")%>">
					Ir al listado de Cursos </a>
</body>
</html>