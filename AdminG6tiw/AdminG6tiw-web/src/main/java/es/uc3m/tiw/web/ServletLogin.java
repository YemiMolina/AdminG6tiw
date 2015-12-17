package es.uc3m.tiw.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BaseDatos
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList <Usuario>  listaUsuarios;
	public static ArrayList <Usuario>  listaUsuariosPermitido;
	public static ArrayList <Usuario>  listaCursos;
	
	
	
	public void init() throws ServletException {
		
		
		
		Usuario alumno1 = new Usuario("borjita", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "" );
		Usuario alumno2 = new Usuario("carlos", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "");
		Usuario profesor1 = new Usuario("profe", "pass1", "Borja", "Perez", 21,2,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "");
		Usuario admin = new Usuario("admin", "admin", "Administrador", "The boss", 21,0,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "");
		
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(alumno1);
		listaUsuarios.add(alumno2);
		listaUsuarios.add(profesor1);
		listaUsuarios.add(admin);
		listaUsuariosPermitido =new ArrayList<Usuario>();
		listaUsuariosPermitido.add(admin);
		
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String accion = request.getParameter("accion");
		switch (accion) {
		case "Index":
			this.getServletConfig().getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			break;
		case "Salir":
			session.invalidate();
			this.getServletConfig().getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			break;
		case "Perfil":
			if (session.getAttribute("usuario") != null) {
				request.setAttribute("usuario", session.getAttribute("usuario"));
				this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
			}
			else{
				this.getServletConfig().getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			}
			
			break;
		case "Perfil2":
				request.getAttribute("usuario");
				this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
			
		case "Perfiles":
			request.setAttribute("usuarios", listaUsuarios);
			this.getServletConfig().getServletContext().getRequestDispatcher("/MuestraUsuarios.jsp").forward(request, response);
			break;
			
		case "delete":
			
			String id=(String) request.getParameter("id");
			Integer idInt=0;
			if(id!=null){
				//idInt= Integer.valueOf(id);
			}
				if(accion!=null && accion.equals("delete")){
					//listaUsuarios.remove(idInt.intValue());
					//listaUsuarios.remove(id);
					int antes=listaUsuarios.size();
					listaUsuarios.remove(id);//quitar ese objeto
					for (int p=0;p<listaUsuarios.size();p++){
						if(listaUsuarios.get(p).getUsuario().equals(id)==true && listaUsuarios.get(p).getUsuario().equals("admin")==false){
							listaUsuarios.remove(p);// borro asi
							
						}else if (listaUsuarios.get(p).getUsuario().equals("admin")==true){
							// deberia aparecer un mensaje como no way nigga pero no se como importarlo voy a  dejarlo que no haga nada y fuera
							System.out.println(" no se borra nada ");
						}
					}
					int despues=listaUsuarios.size();
					System.out.println(despues);
				}
				request.setAttribute("Listacursos", listaUsuarios);
				this.getServletConfig().getServletContext().getRequestDispatcher("/UsuarioBorrado.jsp").forward(request, response);
				
			
		
		}
		
		/*this.getServletContext().getRequestDispatcher("/Index.jsp").forward(request,response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("user");
		String password = request.getParameter("pasw");
		String mensaje ;
		String pagina = "/Index.jsp";
		
		HttpSession session = request.getSession();
		/*ServletContext contexto = session.getServletContext();*/
		Usuario u = comprobarUsuario (user, password);
		if (u != null){
			
			pagina = "/Perfil.jsp";
			request.setAttribute("usuarios", listaUsuarios);
			request.setAttribute("usuario", u);
			/*request.setAttribute("acceso", "ok");*/
			session.setAttribute("usuario", u);
			
		}else{
			mensaje = "Usuario o contraseña incorrectos";
			request.setAttribute("mensaje", mensaje);
		}
		this.getServletContext().getRequestDispatcher(pagina).forward(request, response);
		
	}
	
	private Usuario comprobarUsuario(String user, String password){
		Usuario u = null;
		for(Usuario usuario: listaUsuariosPermitido){
			if(user.equals(usuario.getUsuario()) && password.equals(usuario.getClave())){
				u = usuario;
				break;
			}
		}
		return u;
	}

}