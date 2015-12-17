package es.uc3m.tiw.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletValidar
 */
@WebServlet("/ServletValidar")
public class ServletValidar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList <Curso> ListacursosValidados= new ArrayList<Curso>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletValidar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//NO ESTOY USANDO AHORA ESTE SERVLET, NO OBSTANTE SERIA INTERESANTE CONSERVARLO PARA EL CASO QUE HAY QUE OCULTAR PAGINAS O GUARDAR LAS PAGINAS VALIDADAS EN ALUN SITIO
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ServletCursos sacarCurso= new ServletCursos();
		ArrayList <Curso> Listacursos =sacarCurso.getListaCursos();
		out.println(Listacursos.get(0).getTitulo());
		
		// voy a pasar la lista de curssos al jsp para validarla
		request.setAttribute("Listacursos", Listacursos);
		getServletContext().getRequestDispatcher("/Catalogo.jsp").forward(request, response);
		
		
	}

}
