package es.uc3m.tiw.web;

import java.util.ArrayList;

public class Curso {
	private String titulo;
	private String descripcion;
	private String dificultad;
	private int numeroh;
	private double precio;
	private String imagenuri;
	private int id;
	private double descuento;
	private boolean validado=false;// la validacion es falsa por deecto
	private boolean destacado=false; // un curso no sera destacado por defecto
	private double comisionPortal=0.3;
	private double comisionProfesor=0.7;
	private double dineroPortal;
	private double dineroProfe;
	private Leccion leccion;
	private ArrayList<Leccion> ListaLecciones= new ArrayList <Leccion>();
	public ArrayList<Usuario> ListaUsuarios= new ArrayList<Usuario>();
	
	public Curso(String titulo, String descripcion, String dificultad,
			int numeroh, double precio, String imagenuri, int id, double descuento) {
		//Para cuando quiera meter todos los parametros de una vez
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.dificultad = dificultad;
		this.numeroh = numeroh;
		this.precio = precio;
		this.imagenuri = imagenuri;
		this.id = id;
		this.descuento = descuento;
	}
	
	public Curso (String titulo, String descripcion, String dificultad, int numeroh, double precio,int id, double descuento){
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.dificultad=dificultad;
		this.numeroh=numeroh;
		this.precio=precio;
		this.descuento=descuento;
		this.id=id;
	}
	public Curso(){
		
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public ArrayList<Leccion> getListaLecciones() {
		return ListaLecciones;
	}
	public void setListaLecciones(ArrayList<Leccion> listaLecciones) {
		ListaLecciones = listaLecciones;
	}
	public String getImagenuri() {
		return imagenuri;
	}
	public void setImagenuri(String imagenuri) {
		this.imagenuri = imagenuri;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
		
		public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
			ListaUsuarios = listaUsuarios;
		}
		
		public ArrayList<Usuario> getListaUsuario(){
			return ListaUsuarios;
	    } 
		public void setLeccion(Leccion leccion){
			this.leccion=leccion;
		}
		public Leccion getLeccion(){
			return leccion;
		}
	
	

}

