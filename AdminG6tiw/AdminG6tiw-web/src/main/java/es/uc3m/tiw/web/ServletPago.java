package es.uc3m.tiw.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.daos.CursoDao;
import es.uc3m.tiw.model.daos.ICurso;
import es.uc3m.tiw.model.daos.ILeccion;
import es.uc3m.tiw.model.daos.IUsuario;
import es.uc3m.tiw.model.daos.LeccionDao;
import es.uc3m.tiw.model.daos.UsuarioDao;

/**
 * Servlet implementation class ServletPago
 */
@WebServlet("/ServletPago")
public class ServletPago extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
	@PersistenceContext(unitName = "AdminG6tiw-model")
	EntityManager em;
	@Resource
	UserTransaction ut;
	ILeccion dao;
	ICurso daoc;
	IUsuario daou;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPago() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new LeccionDao(em, ut);
		daoc = new CursoDao(em, ut);
		daou = new UsuarioDao(em, ut);
	}

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=(String) request.getParameter("id");
        int idint= Integer.parseInt(id);
        //busca el curso con el id
        Curso encontrado= BuscarCurso(idint);

        HttpSession session = request.getSession();
        Usuario usuActual= (Usuario)session.getAttribute("usuario");
        
        //Busco en usuario actual
        /*//iniar la sesion y meto el objeto que quiera
        request.getSession().setAttribute("usuarioActual", usuActual);
        //Aqui meto la info del obj usuario y ya puedo acceder a el y obtener lo que quiera
        Usuario usuActual2= (Usuario) request.getSession().getAttribute("usuarioActual");*/
       
        Usuario usuActual1= BuscarUsuario(1);

        List<Curso> CursosMatriculados = new ArrayList<Curso>();
       
       // CursosMatriculados=usuActual.getUsuarioCurso();
       // encontrado.matricular(usuActual);
        CursosMatriculados= usuActual1.getListaCursos();
        CursosMatriculados.add(encontrado);
        
       
			daou.update(usuActual1);
		
        //CursosMatriculados= Usuario.Matricular(encontrado);
        
        
        request.setAttribute("CursosMatriculados", CursosMatriculados);
        request.setAttribute("Curso", encontrado);
       
        
        
        //ServletRegistroUsuario.listaUsuarios.get(usuActual);//añadir usuario a la lista de usuarios
        request.setAttribute("usuario", usuActual1);
       /* request.setAttribute("apellidos", usuActual.getApellidos());*/
        request.setAttribute("nombre", usuActual1.getNombre());
         
        
        
        this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    
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

	public Usuario BuscarUsuario(int id) {
		// int IdCurso2=0;
		Usuario UsuarioEncontrado = null;
		try {
			UsuarioEncontrado = daou.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsuarioEncontrado;
	}

}