package es.uc3m.tiw.web;

import java.util.Hashtable;

public class Leccion {
	private String descripcion;
	private Curso curso;
	private int id;// identificar la leccion con el curso. Si el id de curso es igual al id 
	private int identificador;//identificador de la leccion
	private String material;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	

}

/*


public class HashtableLecciones {

public static void main(String args[]) {


Hashtable lecciones = new Hashtable();

lecciones.put("Google", "United States");
lecciones.put("Nokia", "Finland");
lecciones.put("Sony", "Japan");

lecciones.get("Google");
}}
*/