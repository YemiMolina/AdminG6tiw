package es.uc3m.tiw.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idusuarios;
	private String nombre;
	
	@ManyToMany
	private List <Curso> ListaCursosAlumno =new ArrayList <Curso>();
	
	@OneToMany(mappedBy="Profesor")
	private List <Curso> ListaCursosProfesor =new ArrayList <Curso>();

	public List<Curso> getListaCursosAlumno() {
		return ListaCursosAlumno;
	}

	public void setListaCursosAlumno(List<Curso> listaCursosAlumno) {
		ListaCursosAlumno = listaCursosAlumno;
	}

	public Usuario() {
	}

	public int getIdusuarios() {
		return this.idusuarios;
	}

	public void setIdusuarios(int idusuarios) {
		this.idusuarios = idusuarios;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*
	 * package es.uc3m.tiw.model;

import javax.persistence.Entity;



@Entity
public class Usuario extends Persona {

	private static final long serialVersionUID = 1L;

	

	private ROL rol;

	public ROL getRol() {
		return rol;
	}

	public void setRol(ROL rol) {
		this.rol = rol;
	}

	public Usuario() {
	}

	public Usuario(String nombre, String apellidos, String nick, String password) {
		super(nombre, apellidos, nick, password);
	}
	public Usuario(String nombre, String apellidos, String nick, String password,ROL rol) {
		super(nombre, apellidos, nick, password);
		this.rol = rol;
	}

	@Override
	public String toString() {
		
		return super.toString()+" Usuario [" + (rol != null ? "rol=" + rol : "") + "]";
	}

}
	 * 
	 * 
	 * */

	public List<Curso> getListaCursosProfesor() {
		return ListaCursosProfesor;
	}

	public void setListaCursosProfesor(List<Curso> listaCursosProfesor) {
		ListaCursosProfesor = listaCursosProfesor;
	}
	
	
	/*public static List<Curso> Matricular (Curso curso){ //le paso el id del curso
		//tengo su lista de cursos
		List <Curso> ListaCursos =new ArrayList <Curso>();
		//Se lo añado
		 ListaCursos.add(curso);
		return ListaCursos;
	}*/

}