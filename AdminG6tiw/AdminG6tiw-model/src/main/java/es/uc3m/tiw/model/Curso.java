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

	@ManyToMany(cascade = ALL)
	private List<Usuario> Alumnos;

	private double comisionPortal=0.3;
	private double comisionProfesor=0.7;
	//añadisdos despuesde la prueba dl dia 16
	private String descripcion;
	private double descuento;
	private double descuentoPromocion=0;
	private boolean destacado=false; // un curso no sera destacado por defecto
	private String dificultad;
	private double dineroPortal;
	private double dineroProfe;
	private int id;// este id es secundario ya, no me va a hacer falta
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idcursos;
	private String imagenuri;
	
	@OneToOne(cascade = ALL)
	private Leccion leccion;
	
	@OneToMany(cascade = ALL, fetch=FetchType.LAZY)
	private List<Leccion> ListaLecciones= new ArrayList <Leccion>();
	
	@ManyToMany(cascade = ALL)
	private List<Usuario> ListaAlumnos= new ArrayList<Usuario>();
	
	private int numeroh;
	private double precio;
	
	@ManyToOne(cascade = ALL)
//	@JoinColumn()
	private Usuario Profesor ;

	private String titulo;
	private boolean validado=false;// la validacion es falsa por deecto
	
	public Curso() {
		super();
	}
	
	public Curso (int id, String titulo){
		super();
		this.idcursos=id;
		this.titulo=titulo;
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
	
	public Curso ( String titulo, String descripcion, String dificultad, int numeroh, double precio, String imagenUri, double descuento, Usuario profesor){
		this.titulo=titulo;
		this.descripcion = descripcion;
		this.dificultad = dificultad;
		this.numeroh = numeroh;
		this.precio = precio;
		this.imagenuri = imagenUri;
		this.descuento = descuento;
		this.Profesor = profesor;
		
	}
	public void AddUsuario(Usuario usuario){
		ListaAlumnos.add(usuario);
	}
		
	
	

	public double getComisionPortal() {
		return comisionPortal;
	}

	public double getComisionProfesor() {
		return comisionProfesor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getDescuento() {
		return descuento;
	}

	public double getDescuentoPromocion() {
		return descuentoPromocion;
	}
	public boolean getDestacado() {
		return destacado;
	}
	
	public String getDificultad() {
		return dificultad;
	}
	public double getDineroPortal() {
		return dineroPortal;
	}
	
	public double getDineroProfesor() {
		return dineroProfe;
	}
	public Integer getIdcursos() {
		return this.idcursos;
	}
	public String getImagenuri() {
		return imagenuri;
	}
	public Leccion getLeccion(){
		return leccion;
	}
	public List<Leccion> getListaLecciones() {
		return ListaLecciones;
	}
	public List<Usuario> getListaAlumnos(){
		return ListaAlumnos;
	}
	public int getNumeroh() {
		return numeroh;
	}
	public double getPrecio() {
		return precio;
	}
	public double getPrecioFinal(){
		return precio-descuento;
	}
	public Usuario getProfesor() {
		return Profesor;
	}
	//Funcion en la que el profesor se queda con el 70% del precio del curso
	public Double getSalarioProfesor(){
	double Salario= getPrecioFinal()*0.70;
	int numeroUsuarios=ListaAlumnos.size();
	double salarioTotal=numeroUsuarios*Salario;
	setDienroProfesor(salarioTotal);
	return salarioTotal;
	}
	public String getTitulo() {
		return this.titulo;
	}
	
	public boolean getValidacion() {
		return validado;
	}
	public void setComisionPortal(double comision) {
		this.comisionPortal = comision;
	}
	public void setComisionProfesor(double comision) {
		this.comisionProfesor = comision;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public void setDescuentoPromocion(double descuentoPromocion) {
		this.descuentoPromocion = descuentoPromocion;
	}
	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}
	public void setDienroPortal(double dinero) {
		this.dineroPortal = dinero;
	}
	public void setDienroProfesor(double dinero) {
		this.dineroProfe = dinero;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public void setIdcursos(Integer idcursos) {
		this.idcursos = idcursos;
	}
	public void setImagenuri(String imagenuri) {
		this.imagenuri = imagenuri;
	}
	public void setLeccion(Leccion leccion){
			this.leccion=leccion;
		}
		public void setListaLecciones(List<Leccion> listaLecciones) {
			ListaLecciones = listaLecciones;
		} 
		
		public void setListaAlumnos(List<Usuario> listaUsuarios) {// da aqui el error de la lista
			ListaAlumnos = listaUsuarios;
		}
		
		public void setNumeroh(int numeroh) {
			this.numeroh = numeroh;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
		public void setProfesor(Usuario profesor) {
			Profesor = profesor;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public void setValidacion(boolean validar) {
			this.validado = validar;
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
						+ ", ListaUsuarios=" + ListaAlumnos + "]";
				}

}