package es.uc3m.tiw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;



@Entity
public class Direccion {


	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	private String calle;
	private String poblacion;
	private int  numero;
	private int cp;
	
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Direccion [" + (id != null ? "id=" + id + ", " : "")
				+ (calle != null ? "calle=" + calle + ", " : "")
				+ (poblacion != null ? "poblacion=" + poblacion + ", " : "")
				+ "numero=" + numero + ", cp=" + cp + "]";
	}
	
}
