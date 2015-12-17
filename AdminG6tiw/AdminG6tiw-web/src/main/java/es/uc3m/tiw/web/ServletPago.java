package es.uc3m.tiw.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.text.DateFormat;

import javax.annotation.Resource;
import javax.ejb.EJB;
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

import es.uc3m.tiw.ejb.ConciliadoEjbLocal;
import es.uc3m.tiw.ejb.PagoEjbLocal;
import es.uc3m.tiw.ejb.PagosEjb;
import es.uc3m.tiw.model.Conciliado;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Pedido;
import es.uc3m.tiw.model.PedidoPagoTIW;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.Vale;
import es.uc3m.tiw.model.daos.ConciliadoDao;
import es.uc3m.tiw.model.daos.CursoDao;
import es.uc3m.tiw.model.daos.IConciliado;
import es.uc3m.tiw.model.daos.ICurso;
import es.uc3m.tiw.model.daos.ILeccion;
import es.uc3m.tiw.model.daos.IPedidoTIW;
import es.uc3m.tiw.model.daos.IUsuario;
import es.uc3m.tiw.model.daos.IValeDescuento;
import es.uc3m.tiw.model.daos.LeccionDao;
import es.uc3m.tiw.model.daos.PedidoDaoTIW;
import es.uc3m.tiw.model.daos.UsuarioDao;
import es.uc3m.tiw.model.daos.ValeDescuentoDao;

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
	IValeDescuento daov;
	IPedidoTIW daoped;// este lo que va  a ahcer es guardar las ordenenes de pago que ha confirmado el banco en la base de datos de tiw
	IConciliado daocon;
	@EJB
	PagoEjbLocal interfaz;
	//@EJB
	//ConciliadoEjbLocal interfazConciliado;
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
		daov = new ValeDescuentoDao(em, ut);
		daoped= new PedidoDaoTIW(em, ut);
		daocon=new ConciliadoDao(em,ut);
	}

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion=null;// por defecto asi
   	 accion=request.getParameter("action");
    	
    	String id=(String) request.getParameter("id");
        int idint= Integer.parseInt(id);
                
        String redireccion="/Matriculacion.jsp";
        
        if(accion!=null&&accion.equals("conciliar")){// este if te manda a la zona xa q concilie todos los pagos
     	   List<PedidoPagoTIW> listaPago=null;
     	   try {
 			 listaPago = daoped.findAll();
 		} catch (InstantiationException | IllegalAccessException
 				| ClassNotFoundException | SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}// hay q recoger todas las ordenes de dpedido
     	  int pagosRecuperados= listaPago.size();
     	  request.setAttribute("ListaPago", listaPago);
     	  request.setAttribute("nPagos", pagosRecuperados);
     	  redireccion="/PersistenceConciliarPagos.jsp";
        } else{
 	        //busca el curso con el id";
 	        Curso encontrado= BuscarCurso(idint);
 	        HttpSession session = request.getSession();
 	        Usuario usuActual= (Usuario)session.getAttribute("usuario");
 	        
 	        //Busco en usuario actual
 	        /*//iniar la sesion y meto el objeto que quiera
 	        request.getSession().setAttribute("usuarioActual", usuActual);
 	        //Aqui meto la info del obj usuario y ya puedo acceder a el y obtener lo que quiera
 	        Usuario usuActual2= (Usuario) request.getSession().getAttribute("usuarioActual");*/
 	       
 	        Usuario usuActual1= BuscarUsuario(1);// se suppone q aqui rellena el usuario
 	
 	       // CursosMatriculados=usuActual.getUsuarioCurso();
 	       // encontrado.matricular(usuActual);
 	       //CursosMatriculados= Usuario.Matricular(encontrado);
 	        
 	        
 	        List<Curso> CursosMatriculados = new ArrayList<Curso>();
 	        CursosMatriculados= usuActual1.getListaCursosAlumno();
 	        CursosMatriculados.add(encontrado);
 	        daou.update(usuActual1);
 	        request.setAttribute("CursosMatriculados", CursosMatriculados);
 	        request.setAttribute("Curso", encontrado);
 	       
 	        Usuario profesorcurso=encontrado.getProfesor();
 	        int idprofesor= profesorcurso.getIdusuarios();
 	        List<Vale> ListaVales= daov.BuscarValesProfesor(idprofesor);
 	        
 	        List<Vale> ListaValesFinal= new ArrayList<Vale>();
 	        
 	        for (int i = 0; i < ListaVales.size(); i++) {
 	
 	        	/*if(encontrado.getPrecioFinal()==ListaVales.get(i).getNumeroMinMatricula()&&
 	        	usuActual1.getListaCursosProfesor().size()==ListaVales.get(i).getNumeroCursosinscrito() &&
 	        	ListaVales.get(i).getFechaCaducidad()==ListaVales.get(i).getFechaMaxima())*/
 	  
 	        	
 	        	if(encontrado.getPrecio()>ListaVales.get(i).getNumeroMinMatricula()&&
 	                	usuActual1.getListaCursosAlumno().size()==ListaVales.get(i).getNumeroCursosinscrito()&&
 	                			ListaVales.get(i).getFechaCaducidad().after(new Date())
 	        			)
 	        	{
 	        		Vale vale = ListaVales.get(i);
 	        		ListaValesFinal.add(vale);
 	        		
 	        		
 	        	}
 				
 			}
 	        request.setAttribute("ListaValesFinal", ListaValesFinal);
 	        //ServletRegistroUsuario.listaUsuarios.get(usuActual);//añadir usuario a la lista de usuarios
 	        request.setAttribute("usuario", usuActual1);
 	       /* request.setAttribute("apellidos", usuActual.getApellidos());*/
 	        request.setAttribute("nombre", usuActual1.getNombre());
 	        int idUser=usuActual1.getIdusuarios();
 	        request.setAttribute("idUsuario", usuActual1.getIdusuarios());
 	        request.setAttribute("idProfesor", profesorcurso.getIdusuarios());// es bueno pasar el id de profesor porque la practica exige q sepamos tanto el id del porfe como del alumno q hacen la matriculacion
 	        request.setAttribute("precio", encontrado.getPrecio());
 	        request.setAttribute("precioFinal", encontrado.getPrecio());
 	        redireccion="/Matriculacion.jsp";
        }// din del else que ejecuta la operacion de crear los pagos en la base de datos 
        
         this.getServletConfig().getServletContext().getRequestDispatcher(redireccion).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action=request.getParameter("action");
    	 String idCurso=request.getParameter("idCurso");
    	 String idProfesor=request.getParameter("idProfesor");
    	 String idUsuario=request.getParameter("idUsuario");// el id del usuairio que paga
    	 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	 Date date = new Date();
    	 String mesActual =Integer.toString(date.getMonth());
    	
        
    	 if(action!=null && action.equals("pagar")){
         	String codigoTarjeta=request.getParameter("codigoTarjeta");
        	 String precioFinal=request.getParameter("precioFinal");
        	 double precioFinal1=Double.parseDouble(precioFinal);
             //para comprobar que vaya
           	Pedido pedido= new Pedido();
           	//pedido.setCodigopedido("");
           	pedido.setCodigoTarjeta(codigoTarjeta);
           	pedido.setImporte(precioFinal1);
           	////pedido.setIdPagador(Integer.parseInt(idUsuario));// seria interesante que le lllegase el id de la persona que esta pagando el curso -- comentarle a rocio
           	//pedido.setIdProfesor(Integer.parseInt(idProfesor));
           	//pedido.setIdCurso(Integer.parseInt(idCurso));
           	String obj=interfaz.pagar(pedido);
           	System.out.println("que hay en obj "+obj);
           	// ahora guardo las cosas en la bd de tiw
           	PedidoPagoTIW pedidoPago=new PedidoPagoTIW();
           	int hora=date.getHours();
           	int minutos=date.getMinutes();
           	int segundos=date.getSeconds();
           	String tiempo=Integer.toString(hora+date.getMinutes()+date.getSeconds());
           	String idTiempo=tiempo+" "+Integer.toString(minutos)+" "+Integer.toString(segundos);
           	System.out.println("que hay en date "+date.getHours()+""+date.getMinutes()+" "+date.getSeconds());
           	pedidoPago.setCodigoPedido(" pedido en fecha "+idTiempo);
           	pedidoPago.setCodigoOperacion(obj);
           	pedidoPago.setImporte(precioFinal1);
           	pedidoPago.setNumeroTarjeta(codigoTarjeta);
           
            pedidoPago.setFechaPedido(date.toString());
           	
           	pedidoPago.setIdPagador(Integer.parseInt(idUsuario));// seria interesante que le lllegase el id de la persona que esta pagando el curso -- comentarle a rocio
           	pedidoPago.setIdProfesor(Integer.parseInt(idProfesor));
           	pedidoPago.setIdCurso(Integer.parseInt(idCurso));
           	
           	try {
 				daoped.guardarPedido(pedidoPago);
 			} catch (SecurityException | IllegalStateException
 					| RollbackException | HeuristicMixedException
 					| HeuristicRollbackException | SystemException
 					| NotSupportedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
           	
           	
           	request.setAttribute("ExitoAniadir", true);
           	this.getServletConfig().getServletContext().getRequestDispatcher("/Mensaje.jsp").forward(request, response);
               
              // ifn del if de pagar el curso con la tarjeta de credito
         }else if(action!=null && action.equals("conciliar")){// aqui pretendo hacer toda la parte de conciliar los pagos para el banco, el profe y el alumno
         	List<PedidoPagoTIW> listaPago=null;
         	try {
 					 listaPago=daoped.findAll();
 				} catch (InstantiationException | IllegalAccessException
 						| ClassNotFoundException | SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
         		 
         		 String[] listaPago2=request.getParameterValues("ListaPago");
         		 String listaPago3=request.getParameter("ListaPago");
         		 int tam= listaPago.size();
         		 int aux=1;
         		
         		Calendar cal = Calendar.getInstance();
         		cal.setTime(date);
         		int year = cal.get(Calendar.YEAR);
        		int month = cal.get(Calendar.MONTH)+1;
         		 for(PedidoPagoTIW pagos: listaPago) {
         			 double precioTotal=pagos.getImporte()*0.99;
         			 double tasaBanco=pagos.getImporte()*0.01;
         			 double parteProfe=0.7*precioTotal;
         			 double partePortal=0.3*precioTotal;
         			String fecha=null;
         			 fecha=pagos.getFechaPedido();
         			String trimo=null;
         			
         			 System.out.println("pago numero "+aux+ "operacion"+pagos.getCodigoOperacion());
         			 if (fecha==null){
         				fecha=date.toString();
         				trimo=fecha.substring(24, 28);
         				
         			 }
         			 
					String mes=Integer.toString(month);
         			 int ii=Integer.parseInt(mes);
         			String anio=Integer.toString(year);
         			 String codigoBanco=pagos.getCodigoOperacion();
         			 Conciliado conciliado=new Conciliado();
         			 conciliado.setCodigoBanco(codigoBanco);
         			 conciliado.setAnio(anio);
         			 conciliado.setMes(mes);
         			 conciliado.setImporte(partePortal);
         			 conciliado.setIdProfe(0);// 0 es el id del portal
         			 
         			 try {
						daocon.guardarConciliado(conciliado);
					} catch (SecurityException | IllegalStateException
							| RollbackException | HeuristicMixedException
							| HeuristicRollbackException | SystemException
							| NotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         			Conciliado conciliado2=new Conciliado();// arte del profesor q concilia
         			conciliado2.setCodigoBanco(codigoBanco);
        			 conciliado2.setAnio(trimo);
        			 conciliado2.setMes(mes);
        			 conciliado2.setImporte(parteProfe);
        			 conciliado2.setIdProfe(2);// 0 es el id del portal
         			 
         			try {
						daocon.guardarConciliado(conciliado2);
					} catch (SecurityException | IllegalStateException
							| RollbackException | HeuristicMixedException
							| HeuristicRollbackException | SystemException
							| NotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         			//interfazConciliado.pagar(conciliado);
         			 
         			 
         			 aux++;
         		 }
         		 //request.getParameter("ListaPago");
         		 this.getServletConfig().getServletContext().getRequestDispatcher("/PersistenceCambioPromociones.jsp").forward(request, response);
         //
         }else{// aqui creo que entra si esta haciendo la parte de los vales o poniendo el precio del curso quitando los vales
             	 String cantidad=request.getParameter("vale");
               	Integer cantidad1=0;
               	if(cantidad!=null){
                   cantidad1=Integer.parseInt(cantidad) ;}
               	double precio1=0.0;
                   String precio= request.getParameter("precio");
                   if(precio!=null){
                   precio1= Double.parseDouble(precio);}
                  
                   double precioFinal= precio1-cantidad1;
                   request.setAttribute("precioFinal", precioFinal);
                   request.setAttribute("precio", precio1);
                   request.setAttribute("idCurso", idCurso);
                   request.setAttribute("idUsuario", idUsuario);
                   request.setAttribute("idProfesor", idProfesor);
                   this.getServletConfig().getServletContext().getRequestDispatcher("/PagoFinal.jsp").forward(request, response);
                   
               }
        
        
    
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