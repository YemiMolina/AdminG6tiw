package es.uc3m.tiw.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.tiw.model.daos.CursoDao;
import es.uc3m.tiw.model.daos.ICurso;
import es.uc3m.tiw.model.daos.ILeccion;
import es.uc3m.tiw.model.daos.LeccionDao;
import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Curso;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Servlet implementation class ServletLecciones
 */
@WebServlet("/ServletLecciones")
@MultipartConfig
public class ServletLecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "AdminG6tiw-model")
	EntityManager em;
	@Resource
	UserTransaction ut;
	ILeccion dao;
	ICurso daoc;

	public int contadorId = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLecciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new LeccionDao(em, ut);
		daoc = new CursoDao(em, ut);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String accion = (String) request.getParameter("action");// recojo la
																// accion

		if (accion != null && accion.equals("mostrar")) {

			String id = (String) request.getParameter("id");// id del curso
			int idCurso = Integer.parseInt(id);
			List<Leccion> encontrada = dao.BuscarLeccionCurso(idCurso);// buscas
																		// la
																		// leccion
																		// con
																		// ese
																		// id
			request.setAttribute("Listalecciones", encontrada);
			this.getServletConfig().getServletContext()
					.getRequestDispatcher("/ListaLeccion.jsp")
					.forward(request, response);// manda a la lista

		} else if (accion != null && accion.equals("delete")) {
			// coge la lista de las lecciones y borra la leccion que le han
			// indicado con su id
			String id = (String) request.getParameter("id");// id del curso
																		
			int idLeccion = Integer.parseInt(id);

			Leccion leccionencontrada = null;
			try {
				leccionencontrada = dao.findById(idLeccion);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				dao.removeLeccion(leccionencontrada);
			} catch (IllegalStateException | SecurityException
					| NotSupportedException | SystemException
					| HeuristicMixedException | HeuristicRollbackException
					| RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int curso =leccionencontrada.getCurso().getIdcursos();

			List<Leccion> encontrada = dao.BuscarLeccionCurso(curso);// buscas la leccion con ese id
																		
			request.setAttribute("Listalecciones", encontrada);
			// Si se quiere borrar la leccion

			this.getServletConfig().getServletContext()
					.getRequestDispatcher("/ListaLeccion.jsp")
					.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idCursoUrl = request.getParameter("id");// patametro del curso
		int idCursoUrl1 = Integer.parseInt(idCursoUrl);
		String descripcion = (String) request.getParameter("descripcion");
		// String material =(String) request.getParameter("material");

		Part filePart = request.getPart("material");
		String uri = ServletCursos.guardarImagen(filePart);
		// Curso curso= request.getParameter("curso"); //Pide string y es de
		// tipo Curso

		// crea una nueva leccion con sus atributos

		Leccion leccion = new Leccion();
		Curso cursoleccion = BuscarCurso(idCursoUrl1);
		leccion.setCurso(cursoleccion);
		leccion.setDescripcion(descripcion);
		leccion.setMaterial(uri);

		try {
			dao.createLeccion(leccion);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | IllegalStateException
				| SecurityException | SQLException | NotSupportedException
				| SystemException | HeuristicMixedException
				| HeuristicRollbackException | RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// leccion.setIdentificador(contadorId);// actualizas el contador del id
		// de lecciones
		contadorId++;

		// añado a la leccion el curso al que va dirigido
		// curso.getListaLecciones().add(leccion);

		// GuardarCurso(curso);

		// List<Leccion> listaLecciones = getListaLeccion();

		// listaLecciones.add(leccion);
		// curso.setListaLecciones(listaLecciones);// meter la leccion creada en
		// la lista de curso
		// request.setAttribute("material", material);
		request.setAttribute("descripcion", descripcion);
		request.setAttribute("material", uri);

		request.setAttribute("Listalecciones",
				dao.BuscarLeccionCurso(idCursoUrl1));

		// pinta lo anterior en el jsp catalogo
		getServletContext().getRequestDispatcher("/CatalogoLecciones.jsp")
				.forward(request, response);

	}// peta asi q arreglalo

	public void borrarLeccion(int identificador,
			ArrayList<Leccion> ListaLecciones) {
		Integer idINT2 = 0;
		String identif = Integer.toString(identificador);
		if (identif != null) {
			idINT2 = Integer.valueOf(identificador);
		}
		// ListaLecciones.get(idINT2).setMaterial("_");

		/*
		 * if(accion!=null && accion.equals("delete")){
		 * leecionlista.remove(idINT2.intValue()); }
		 */

	}

	public Leccion CrearLeccion(Leccion leccion) {

		try {
			dao.createLeccion(leccion);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | IllegalStateException
				| SecurityException | SQLException | NotSupportedException
				| SystemException | HeuristicMixedException
				| HeuristicRollbackException | RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return leccion;
	}

	public Curso BuscarCurso(int id) {
		// int IdCurso2=0;
		Curso CursoEncotrado = null;
		try {
			CursoEncotrado = daoc.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CursoEncotrado;
	}

	public Leccion BuscarLeccion(int id) {

		Leccion LeccionEncotrada = null;
		try {
			LeccionEncotrada = dao.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LeccionEncotrada;
	}

	public Curso GuardarCurso(Curso curso) {
		Curso CursoGuardado = null;
		try {
			CursoGuardado = daoc.createCurso(curso);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | IllegalStateException
				| SecurityException | SQLException | NotSupportedException
				| SystemException | HeuristicMixedException
				| HeuristicRollbackException | RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return CursoGuardado;
	}

	public List<Leccion> getListaLeccion() {// solo quiero que me devuelva la
											// lista de cursos
		List<Leccion> ListaLecciones = null;
		try {
			ListaLecciones = dao.findAll();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListaLecciones;
	}

}

