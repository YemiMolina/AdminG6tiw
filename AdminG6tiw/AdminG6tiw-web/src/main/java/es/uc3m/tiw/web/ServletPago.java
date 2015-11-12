package es.uc3m.tiw.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletPago
 */
@WebServlet("/ServletPago")
public class ServletPago extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPago() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=(String) request.getParameter("id");
        int idint= Integer.parseInt(id);
        Curso encontrado= ServletCursos.BuscarCurso(idint);
       
        HttpSession session = request.getSession();
        Usuario usuActual= (Usuario)session.getAttribute("usuario"); 
        //Busco en usuario actual
        
        /*//iniar la sesion y meto el objeto que quiera
        request.getSession().setAttribute("usuarioActual", usuActual);
        //Aqui meto la info del obj usuario y ya puedo acceder a el y obtener lo que quiera
        Usuario usuActual2= (Usuario) request.getSession().getAttribute("usuarioActual");*/
        
        boolean ExitoAniadir= Usuario.AddCurso(encontrado);
        
        ArrayList<Curso> CursosMatriculados = new ArrayList<Curso>();
        CursosMatriculados=usuActual.getUsuarioCurso();
        
        request.setAttribute("CursosMatriculados", CursosMatriculados);
        request.setAttribute("Curso", encontrado);
        request.setAttribute("ExitoAniadir", ExitoAniadir);
        
        
        //ServletRegistroUsuario.listaUsuarios.get(usuActual);//añadir usuario a la lista de usuarios
        request.setAttribute("usuario", usuActual);
        request.setAttribute("apellidos", usuActual.getApellidos());
        request.setAttribute("nombre", usuActual.getNombre());
         
        if(ExitoAniadir=true){

        this.getServletConfig().getServletContext().getRequestDispatcher("/Mensaje.jsp").forward(request, response);
         }
        
        this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    
    }

}