package es.uc3m.tiw.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

import es.uc3m.tiw.model.Curso;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="Leccion")
@NamedQuery(name="Leccion.findAll", query="SELECT u FROM Leccion u")

public class Leccion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private int identificador; //antes id leccion lo he cambiado
	
	private String descripcion;
	private Curso curso;
	//private int idleccion;// antes identificador (identificador de la leccion)
	private String material;
	
	/*public int getId() {
		return idleccion;
	}
	public void setId(int id) {
		this.idleccion = id;
	}*/
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
	@Override
	public String toString() {
		return "Leccion [idleccion=" + ", descripcion="
				+ descripcion + ", curso=" + curso + ", identificador="
				+ identificador + ", material=" + material + "]";
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	

}
