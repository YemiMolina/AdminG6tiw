package es.uc3m.tiw.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPromociones
 */
@WebServlet("/ServletPromociones")
public class ServletPromociones extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    private static ArrayList <Promocion> listaPromocion= new ArrayList <Promocion>();
    private static int contador=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPromociones() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String accion=(String) request.getParameter("action");
        String id=(String) request.getParameter("id");
        Integer idInt=0;
        
        if(id!=null){
        idInt= Integer.valueOf(id);
        }
            if(accion!=null && accion.equals("delete")){
                int id1= Integer.valueOf(id);
                ServletPromociones.Borrarpromocion(id1);
            }
            
        
        request.setAttribute("ListaPromociones", listaPromocion);
        this.getServletConfig().getServletContext().getRequestDispatcher("/Promociones.jsp").forward(request, response);
    
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre =request.getParameter("nombre");
        double descuento= Double.valueOf(request.getParameter("descuento"));
        
        
        Promocion promocion= new Promocion();
        
        promocion.setNombre(nombre);
        promocion.setDescuento(descuento);
        promocion.setId(contador);
        contador++;
        
        listaPromocion.add(promocion);
        
        request.setAttribute("ListaPromociones", listaPromocion);
        this.getServletConfig().getServletContext().getRequestDispatcher("/Promociones.jsp").forward(request, response);
    
        
        
    }

    public static Promocion Buscarpromocion(int id) {
        Promocion promocion = null;
        for (int i = 0; i < listaPromocion.size(); i++) {
            Promocion element = listaPromocion.get(i);
            if (element.getId() == id) {
                promocion=element;
                i=listaPromocion.size();
            }
        }

        return promocion;
    }
    
    public static void Borrarpromocion(int id){
    Promocion promocion=Buscarpromocion(id);
    listaPromocion.remove(promocion);
    }
    
    
}