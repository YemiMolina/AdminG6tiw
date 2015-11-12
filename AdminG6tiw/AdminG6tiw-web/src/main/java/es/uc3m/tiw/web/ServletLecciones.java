package es.uc3m.tiw.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import es.uc3m.tiw.web.Curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ServletLecciones
 */
@WebServlet("/ServletLecciones")
@MultipartConfig
public class ServletLecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static int contadorId=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLecciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String accion=(String) request.getParameter("action");
		System.out.println("imprimir accion "+ accion);
		String id=(String) request.getParameter("curso");//lega el curso
		System.out.println("imprimir codigo curso "+ id);
		String identificador=(String) request.getParameter("id");// aqui va a llegar el identificador no  el id de curso
		
		if(id!=null){
			Integer idINT2=0;
			int idint= Integer.parseInt(id);
			System.out.println("imprimir el codigo de curso "+ idint+ " que viene de "+id);
			System.out.println("imprimir el codigo de leccion "+ identificador);
			Curso encontrado= ServletCursos.BuscarCurso(idint); //id del curso, asi enlazan las listas
			System.out.println("imprimir tamaño de lista "+ encontrado.getListaLecciones().size());
			//System.out.println("imprimir tamaño de lista "+ encontrado.getListaLecciones().get(1));
			ArrayList<Leccion>	leecionlista=encontrado.getListaLecciones();
			if(identificador!=null){
				idINT2= Integer.valueOf(identificador);
				
				}
			System.out.println("imprimir que valor tiene idINT2 "+idINT2);
			//System.out.println("imprimir que valor tiene el identificados dentro de lalista "+leecionlista.get(0).getDescripcion());
			if(idINT2>0){
				idINT2=idINT2-1;
			}
			
			if(accion!=null && accion.equals("delete")){// borrar lecciones
				if (leecionlista.size()<=1){//cuando solo tengo uno en la lista
					System.out.println("imprimir estas en ultimo "+leecionlista.get(0));
					leecionlista.remove(0);//quitas el ultimo
					
				}else{
					leecionlista.remove(idINT2.intValue());	
				}
				
				
			}
			if(accion!=null && accion.equals("deleteL")){//este es el de borrar material 
				System.out.println("imprimir estoy en borrar material: "+idINT2);
				leecionlista.get(idINT2).setMaterial("NADA");// hasta aqui no va bien el problema es que solo puedo borrar el material de la primera leccion en el jsp no se ve ningun mensaje de se ha borrado tu archivo
				out.println("se ha eliminado el archivo");
				 //out.println("<html><body onload=\"alert('Hello World')\"></body></html>");
				this.getServletConfig().getServletContext().getRequestDispatcher("/ListaLeccion.jsp").forward(request, response);
			}
			request.setAttribute("Listalecciones", leecionlista);
			this.getServletConfig().getServletContext().getRequestDispatcher("/ListaLeccion.jsp").forward(request, response);
			
		}else {
			System.out.println("imprimir el codigo de curso ");
			int idint=0;
			Curso encontrado= ServletCursos.BuscarCurso(idint); //id del curso, asi enlazan las listas
			System.out.println("imprimir el curso encontrado "+encontrado);
			ArrayList<Leccion>	leecionlista=encontrado.getListaLecciones();
			request.setAttribute("Listalecciones", leecionlista);
			this.getServletConfig().getServletContext().getRequestDispatcher("/ListaLeccion.jsp").forward(request, response);
		}
		
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCursoUrl= request.getParameter("id");// patametro dl curso
		int idCursoUrl1=Integer.parseInt(idCursoUrl);
		String descripcion =(String) request.getParameter("descripcion");
		//String material =(String) request.getParameter("material");
		
		Part filePart = request.getPart("material");
		String uri= ServletCursos.guardarImagen(filePart);
		//Curso curso= request.getParameter("curso"); //Pide string y es de tipo Curso
		
		//crea una nueva leccion con sus atributos 
		Leccion leccion= new Leccion() ;
		//leccion.setIdentificador(contadorId);// actualizas el contador del id de lecciones
		contadorId++;
		
		leccion.setDescripcion(descripcion);
		leccion.setMaterial(uri);
		//leccion.setMaterial(material);
		//leccion.setCurso(curso);
		
		//guardo el curso de la leccion
		Curso curso= ServletCursos.BuscarCurso(idCursoUrl1);
		//añado a la leccion el curso al que va dirigido
		leccion.setCurso(curso);
		
		ArrayList<Leccion> listaLecciones = curso.getListaLecciones();
		int tam=listaLecciones.size();
		System.out.println("mensaje "+ tam + "nombre de lo que metes "+descripcion);
		if (tam==0){
			leccion.setIdentificador(tam+1);
			//listaLecciones.add(leccion);
			
		}else{
			int ultimo=listaLecciones.get(tam-1).getIdentificador();
			leccion.setIdentificador(ultimo+1);
		}
		System.out.println("mensaje tamaño despues de inspeccionar tam de arraylist leccion "+ tam );	
		
		
		listaLecciones.add(leccion);
		curso.setListaLecciones(listaLecciones);// meter la leccion creada en la lista de curso
		//request.setAttribute("material", material);
		request.setAttribute("descripcion", descripcion);

		request.setAttribute("Listalecciones", listaLecciones);
		
		//pinta lo anterior en el jsp catalogo
		getServletContext().getRequestDispatcher("/CatalogoLecciones.jsp").forward(request, response);
		
		
		
	}//peta asi q arreglalo
	public void borrarLeccion(int identificador, ArrayList<Leccion> ListaLecciones){
		Integer idINT2=0;
		String identif=Integer.toString(identificador);
		if(identif!=null){
			idINT2= Integer.valueOf(identificador);
			}
		//ListaLecciones.get(idINT2).setMaterial("_");
		
		/*if(accion!=null && accion.equals("delete")){
			leecionlista.remove(idINT2.intValue());	
		}*/
		
	}
	
	
	}
/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String accion=(String) request.getParameter("action");
		String id=(String) request.getParameter("id");
		String id2= request.getParameter("id");
		 Integer idint=0;
		String identificador=(String) request.getParameter("identificador");
		Integer idINT2=0;
		//int idint= Integer.parseInt(id);
		Curso encontrado= ServletCursos.BuscarCurso(idint); //id del curso, asi enlazan las listas
		ArrayList<Leccion>	leecionlista=encontrado.getListaLecciones();
		if(identificador!=null){
			idINT2= Integer.valueOf(identificador);
			}//debugar esto para ver q peta
		
		if(accion!=null && accion.equals("delete")){
			//leecionlista.remove(idINT2.intValue());	
			 leecionlista.remove(idint.intValue());   
		}*/



