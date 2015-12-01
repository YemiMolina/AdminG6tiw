package es.uc3m.tiw.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
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

import es.uc3m.tiw.model.Direccion;
import es.uc3m.tiw.model.Leccion;
//import es.uc3m.tiw.model.ROL;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.daos.CursoDao;
import es.uc3m.tiw.model.daos.ICurso;
import es.uc3m.tiw.model.Curso;

/**
 * Servlet implementation class ServletBuscarCursos
 */
@MultipartConfig
@WebServlet("/ServletBuscarCursos")
public class ServletBuscarCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName="AdminG6tiw-model")
	EntityManager em;
	@Resource
	UserTransaction ut;
	ICurso dao;
	List<Curso> listaDevolucion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscarCursos() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	   dao = new CursoDao(em, ut);
    	   super.init(config);
    	  
    	   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("Listacursos", getListaCursos(listaDevolucion));
		String redireccion="/AdminG6tiw-web/PersistenceListarCursos.jsp";
		response.sendRedirect("/PersistenceListarCursos.jsp");// 
		 //request.setAttribute("Listacursos", getListaCursos(listaDevolucion));
		this.getServletConfig().getServletContext().getRequestDispatcher(redireccion).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String campo=null;
		campo=request.getParameter("campo");// ahora no hace nada
		List<Curso> listaCursos =null;
		//List<Curso> listaDevolucion =null;
		try {
			 listaCursos=  dao.findAll();// recupero todaos los cursos para filtrar por aqui
			 listaDevolucion = dao.findAll();
			 listaDevolucion.clear();
			 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String redireccion="/ServletBuscarCursos";
		String busqueda="nulo";
		 busqueda=request.getParameter("busqueda");
		 System.out.println("el campo es : "+campo+ "la promocion es: ");
		 if(campo.equals(null)!=true){// entonces es que se l e ha dado a alguno de los botones
			 if(campo.equals("titulo")){
				 for(Curso curso: listaCursos) {
					 if(curso.getTitulo().equals(busqueda)){// si coincide el titulo lo meto a la lista
						 listaDevolucion.add(curso);
					 }
				 }
				 
			 }else if(campo.equals("precio")){
				 for(Curso curso: listaCursos) {
					 double busquedaDouble=Double.valueOf(busqueda);
					 if(curso.getPrecio()==busquedaDouble){// si coincide el precio lo meto a la lista porbablemente aqui salgan varios
						 listaDevolucion.add(curso);
					 }
				 }
				 
			 }else if(campo.equals("tematica")){
				 for(Curso curso: listaCursos) {
					 if(curso.getDescripcion().equals(busqueda)){// si coincide el tema lo meto a la lista
						 listaDevolucion.add(curso);
					 }
				 }
				 
			 }
			 
			 redireccion="/PersistenceListarCursos.jsp";
		 }else{// no ha marcado nada
			 System.out.println("no ha marcado nada");
			 listaDevolucion=listaCursos;
			 redireccion="/PersistenceListarCursos.jsp";
		 }
		 response.sendRedirect("/PersistenceListarCursos.jsp");// 
		 request.setAttribute("Listacursos", getListaCursos(listaDevolucion));
		 
		 System.out.println("Contenido del request: " + request);
		 System.out.println("Contenido del response: " + response);
		
		 
		// this.getServletConfig().getServletContext().getRequestDispatcher(redireccion).forward(request, response);
	}
	public List <Curso> getListaCursos(List<Curso> ListaCursosRecibida){// solo quiero que me devuelva la lista de cursos
        List<Curso> ListaCursos=null;
        /*try {
            ListaCursos = dao.findAll();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        ListaCursos=ListaCursosRecibida;
        return ListaCursos ;
    }

}

