package es.uc3m.tiw.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Direccion;
import es.uc3m.tiw.model.Leccion;
//import es.uc3m.tiw.model.ROL;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.daos.CursoDao;
import es.uc3m.tiw.model.daos.ICurso;
import es.uc3m.tiw.model.daos.IPersona;
import es.uc3m.tiw.model.daos.PersonaDao;
import es.uc3m.tiw.model.Curso;
/**
 * Servlet implementation class PersistenceServlet
 */
@WebServlet("/usuario")
public class PersistenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName="AdminG6tiw-model")
	EntityManager em;
	@Resource
	UserTransaction ut;
	//IPersona dao;
	ICurso dao;
	
	
	@Override
	public void init() throws ServletException {
		  System.out.println("he llegado al servlet");
		//dao = new PersonaDao(em, ut);
		dao = new CursoDao(em, ut);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersistenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("metodo doget");
		doPost(request, response);
		//List<Curso> listaCursos=null;
		/*try {
			listaCursos = dao.findAll();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}*/
		
	/*	List<Usuario> listaUsuarios = null;
		try {
			listaUsuarios = dao.findAll();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		for (Usuario usuario : listaUsuarios) {
			out.println(usuario);
			out.println("<br/>");
		}
		out.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Usuario usuario = new Usuario();
		//Curso curso= new Curso();
		//curso.setTitulo(request.getParameter("titulo"));
		//curso.setTitulo("prueba2");
		//Curso curso1= new Curso("curso1","descripcion1","dificultad1", 1, 20,130,10.0);
		Usuario usuario = new Usuario();
		Curso curso= new Curso();
		//curso.setTitulo(request.getParameter("titulo"));
		curso.setTitulo("prueba2titulo");
		curso.setDescripcion("descripcion");
		curso.setDificultad("dificultad");
		curso.setImagenuri("uri");
		curso.setNumeroh(2);
		curso.setPrecio(2);
		curso.setValidacion(false);
		curso.setDestacado(false);
		
		curso.setDescuento(0.1);
		curso.setDienroPortal(0);
		curso.setDienroProfesor(0);
		curso.setComisionPortal(0.3);
		curso.setComisionProfesor(0.7);
		//curso.setListaLecciones(listaLecciones);
		List<Leccion> ListaLecciones= new ArrayList <Leccion>();
		Leccion leccion1= new Leccion();
		leccion1.setMaterial("material");
		leccion1.setCurso(curso);
		leccion1.setDescripcion("descripcion");
		leccion1.setId(0);// no hace falta ya
		leccion1.setIdentificador(0);
		ListaLecciones.add(leccion1);
		//curso.setListaLecciones(ListaLecciones);
		curso.setLeccion(leccion1);
		
	
	
		
		
		try {
		dao.createCurso(curso);
		System.out.println("curso creado creado");
	} catch (InstantiationException | IllegalAccessException
			| ClassNotFoundException | IllegalStateException
			| SecurityException | SQLException | NotSupportedException
			| SystemException | HeuristicMixedException
			| HeuristicRollbackException | RollbackException e) {
		
		e.printStackTrace();
	}
		/*usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellidos(request.getParameter("apellidos"));
		usuario.setNick(request.getParameter("nick"));
		usuario.setPassword(request.getParameter("password"));
		String rol = request.getParameter("rol");
		
		switch (rol) {
		case "ESTUDIANTE":
			usuario.setRol(ROL.ESTUDIANTE);
			break;
		case "PROFESOR":
			usuario.setRol(ROL.PROFESOR);
			break;
		case "ADMIN":
			usuario.setRol(ROL.ADMIN);
			
			break;
			

		}
		*/
		/*Direccion direccion = new Direccion();
		direccion.setCalle(request.getParameter("calle"));
		direccion.setCp(Integer.parseInt(request.getParameter("cp")));
		direccion.setNumero(Integer.parseInt(request.getParameter("numero")));
		direccion.setPoblacion(request.getParameter("poblacion"));
		
		usuario.setDireccion(direccion);*/
		
		/*try {
			dao.createUsuario(usuario);
			System.out.println("usuario creado");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | IllegalStateException
				| SecurityException | SQLException | NotSupportedException
				| SystemException | HeuristicMixedException
				| HeuristicRollbackException | RollbackException e) {
			
			e.printStackTrace();
		}*/
		
	response.sendRedirect("usuarios");// ponia usuarios lo he cambiado por cursos
	getServletContext().getRequestDispatcher("/Catalogo.jsp").forward(request, response);
	
	}

}
