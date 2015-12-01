package es.uc3m.tiw.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;
import es.uc3m.tiw.model.Direccion;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
public class Persona implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	@Column(unique = true)
	private String nombre;
	@Column(nullable = true)
	private String apellidos;
	
	@Column(unique = true, nullable = false, length = 10)
	private String nick;
	@Column(nullable = false, length = 10)
	private String password;
	
	@OneToOne(cascade = ALL)
	private Direccion direccion;



	

	

	public Persona(String nombre, String apellidos, String nick,
			String password) {
		super();

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.password = password;
	}


	public Persona(String nombre, String apellidos, String nick,
			String password, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.password = password;
		this.direccion = direccion;
	}


	public Persona() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}





	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Persona [" + (id != null ? "id=" + id + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellidos != null ? "apellidos=" + apellidos + ", " : "")
				+ (nick != null ? "nick=" + nick + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (direccion != null ? "direccion=" + direccion : "") + "]";
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}










   
}
