package es.uc3m.tiw.model;

import java.io.Serializable;
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
	private int idusuarios;

	private String nombre;

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

}