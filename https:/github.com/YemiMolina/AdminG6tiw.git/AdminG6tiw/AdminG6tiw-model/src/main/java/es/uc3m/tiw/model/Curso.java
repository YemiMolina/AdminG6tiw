package es.uc3m.tiw.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Usuario;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private int idcursos;

	private String titulo;
	//añadisdos despuesde la prueba dl dia 16
	private String descripcion;
	private String dificultad;
	private int numeroh;
	private double precio;
	private String imagenuri;
	private int id;// este id es secundario ya, no me va a hacer falta
	private double descuento;
	private boolean validado=false;// la validacion es falsa por deecto
	private boolean destacado=false; // un curso no sera destacado por defecto
	private double comisionPortal=0.3;
	private double comisionProfesor=0.7;
	private double dineroPortal;
	private double dineroProfe;
	
	@OneToOne(cascade = ALL)
	private Leccion leccion;
	
	@OneToMany(cascade = ALL)
	private List<Leccion> ListaLecciones= new ArrayList <Leccion>();
	//ListaLecciones= null;
	@OneToMany
	private ArrayList<Usuario> ListaUsuarios= new ArrayList<Usuario>();

	
	
	public Curso() {
		super();
	}
	
	public Curso (int id, String titulo){
		super();
		this.idcursos=id;
		this.titulo=titulo;
	}
	public Curso ( String titulo, String descripcion, String dificultad, int numeroh, double precio, String imagenUri, double descuento){
		this.titulo=titulo;
		this.descripcion = descripcion;
		this.dificultad = dificultad;
		this.numeroh = numeroh;
		this.precio = precio;
		this.imagenuri = imagenUri;
		this.descuento = descuento;
		
	}
	

	public Curso( String titulo, String descripcion,
			String dificultad, int numeroh, double precio, String imagenuri,
			double descuento, boolean validado, boolean destacado,
			double comisionPortal, double comisionProfesor,
			double dineroPortal, double dineroProfe) {
		super();
		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.dificultad = dificultad;
		this.numeroh = numeroh;
		this.precio = precio;
		this.imagenuri = imagenuri;
		this.descuento = descuento;
		this.validado = validado;
		this.destacado = destacado;
		this.comisionPortal = comisionPortal;
		this.comisionProfesor = comisionProfesor;
		this.dineroPortal = dineroPortal;
		this.dineroProfe = dineroProfe;
	}

	public int getIdcursos() {
		return this.idcursos;
	}

	public void setIdcursos(int idcursos) {
		this.idcursos = idcursos;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecioFinal(){
		return precio-descuento;
	}
	
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public List<Leccion> getListaLecciones() {
		return ListaLecciones;
	}
	public void setListaLecciones(List<Leccion> listaLecciones) {
		ListaLecciones = listaLecciones;
	}
	public String getImagenuri() {
		return imagenuri;
	}
	public void setImagenuri(String imagenuri) {
		this.imagenuri = imagenuri;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public int getNumeroh() {
		return numeroh;
	}
	public void setNumeroh(int numeroh) {
		this.numeroh = numeroh;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public boolean getValidacion() {
		return validado;
	}
	public void setValidacion(boolean validar) {
		this.validado = validar;
	}
	public boolean getDestacado() {
		return destacado;
	}
	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}
	public double getComisionPortal() {
		return comisionPortal;
	}
	public void setComisionPortal(double comision) {
		this.comisionPortal = comision;
	}
	public double getComisionProfesor() {
		return comisionProfesor;
	}
	public void setComisionProfesor(double comision) {
		this.comisionProfesor = comision;
	}
	public double getDineroProfesor() {
		return dineroProfe;
	}
	public void setDienroProfesor(double dinero) {
		this.dineroProfe = dinero;
	}
	public double getDineroPortal() {
		return dineroPortal;
	}
	public void setDienroPortal(double dinero) {
		this.dineroPortal = dinero;
	}
	//Funcion en la que el profesor se queda con el 70% del precio del curso
		public Double getSalarioProfesor(){
		double Salario= getPrecioFinal()*0.70;
		int numeroUsuarios=ListaUsuarios.size();
		double salarioTotal=numeroUsuarios*Salario;
		setDienroProfesor(salarioTotal);
		return salarioTotal;
		}
		public void AddUsuario(Usuario usuario){
			ListaUsuarios.add(usuario);
	    } 
		
		public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {// da aqui el error de la lista
			ListaUsuarios = listaUsuarios;
		}
		
		public ArrayList<Usuario> getListaUsuario(){
			return ListaUsuarios;
	    }

		@Override
		public String toString() {
			return "Curso [idcursos=" + idcursos + ", titulo=" + titulo
					+ ", descripcion=" + descripcion + ", dificultad="
					+ dificultad + ", numeroh=" + numeroh + ", precio="
					+ precio + ", imagenuri=" + imagenuri + ", id=" + id
					+ ", descuento=" + descuento + ", validado=" + validado
					+ ", destacado=" + destacado + ", comisionPortal="
					+ comisionPortal + ", comisionProfesor=" + comisionProfesor
					+ ", dineroPortal=" + dineroPortal + ", dineroProfe="
					+ dineroProfe + ", ListaLecciones=" + ListaLecciones
					+ ", ListaUsuarios=" + ListaUsuarios + "]";
		}
		
		public void setLeccion(Leccion leccion){
			this.leccion=leccion;
		}
		public Leccion getLeccion(){
			return leccion;
		}
		

}