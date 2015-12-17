package es.uc3m.tiw.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Cursos
 */
@WebServlet("/ServletCursos")
@MultipartConfig 
public class ServletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static ArrayList <Curso> Listacursos = new ArrayList<Curso>();   
    
    public static int contadorId=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCursos() {
        super();
        // TODO Auto-generated constructor stub
    }
    /*private String titulo;
	private String descripcion;
	private String dificultad;
	private int numeroh;
	private double precio;
	private String imagenuri;
	private int id;
	private double descuento;*/
    public void init(ServletConfig config) throws ServletException {
        // Always call super.init(config) first  (servlet mantra #1)
        super.init(config);
        Curso curso1= new Curso("curso1","descripcion1","dificultad1", 1, 20,130,10.0);
        Curso curso2= new Curso("curso2","descripcion2","dificultad2", 2, 20,131,10.0);
        Listacursos.add(curso1);
        Listacursos.add(curso2);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String accion=(String) request.getParameter("action");
	String id=(String) request.getParameter("id");
	Integer idInt=0;
	if(id!=null){
	idInt= Integer.valueOf(id);
	}
		if(accion!=null && accion.equals("delete")){
			Listacursos.remove(idInt.intValue());	
		}else if (accion!=null && accion.equals("modificar")){
			
			Curso CursoMod=BuscarCurso(idInt);
			request.setAttribute("CursoModificar", CursoMod);
			request.setAttribute("Listacursos", Listacursos);
			this.getServletConfig().getServletContext().getRequestDispatcher("/Modificacion.jsp").forward(request, response);
		}
		request.setAttribute("Listacursos", Listacursos);
		this.getServletConfig().getServletContext().getRequestDispatcher("/Catalogo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idcurso="";
		idcurso=request.getParameter("id");
		
		String titulo =request.getParameter("titulo");
		String descripcion =request.getParameter("descripcion");
		String dificultad =request.getParameter("dificultad");
		int numeroh =Integer.valueOf(request.getParameter("numeroh"));
		double precio= Double.valueOf(request.getParameter("precio"));
		Part filePart = request.getPart("imagenuri");
		String uri= guardarImagen(filePart);
		
		//Para poder realizar el descuento
		String descuento = request.getParameter("descuento");
		Double tipoDescuento = null;
		if(descuento.equals("fijo")){
			tipoDescuento=10.0;
		}else if(descuento.equals("variable")) {
			tipoDescuento=precio*0.10;
		}else if (descuento.equals("ninguno")){
			tipoDescuento=0.0;
		}
		
		if(idcurso!=null){
			String id=(String) request.getParameter("id");
			Integer idInt=0;
			Curso CursoMod=BuscarCurso(idInt);
			CursoMod.setDescripcion(descripcion);
			CursoMod.setDificultad(dificultad);
			CursoMod.setImagenuri(uri);
			CursoMod.setNumeroh(numeroh);
			CursoMod.setPrecio(precio);
			CursoMod.setTitulo(titulo);
			CursoMod.setDescuento(tipoDescuento);
			
			request.setAttribute("CursoModificar", CursoMod);
			request.setAttribute("Listacursos", Listacursos);
			
		}else{
		//crea un nuevo curso con los atributos 
		Curso curso= new Curso(titulo, descripcion, dificultad, numeroh, precio, uri, contadorId, tipoDescuento);
		curso.setId(contadorId);
		contadorId++;
		curso.setDescripcion(descripcion);
		curso.setDificultad(dificultad);
		curso.setImagenuri(uri);
		curso.setNumeroh(numeroh);
		curso.setPrecio(precio);
		curso.setTitulo(titulo);
		curso.setDescuento(tipoDescuento);

		Listacursos.add(curso);
		
		request.setAttribute("curso", curso);

		request.setAttribute("Listacursos", Listacursos);
		}
		//pinta lo anterior en el jsp catalogo
		getServletContext().getRequestDispatcher("/Catalogo.jsp").forward(request, response);
		
	}
	
	public static String guardarImagen(Part filePart){
		
		Date date = new Date();
		String archivoNombre ="";
		
		if (filePart!=null && filePart.getSize()!= 0){
			archivoNombre= "imagen" + date.getTime();
		//donde se guardan las imagenes
		//lo va leyendo del Part y lo guarda en un lugar del disco
		try {
			FileOutputStream outputStream = new FileOutputStream("/home/tiw/fotos/" + archivoNombre);
			
			int read = 0;
			InputStream inputStream =filePart.getInputStream();
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		return archivoNombre;
	}
	
	public static Curso BuscarCurso(int id){
		int IdCurso2=0;
		Curso Curso2=null;
		for (int i = 0; i < ServletCursos.Listacursos.size(); i++) {
			Curso2= ServletCursos.Listacursos.get(i);
			IdCurso2=Curso2.getId();
			if(IdCurso2==id){
				i=ServletCursos.Listacursos.size();
			}
		}
	return Curso2;	
	}
	
	public ArrayList <Curso> getListaCursos(){// solo quiero que me devuelva la lista de cursos
		
		return Listacursos;
	}
}
