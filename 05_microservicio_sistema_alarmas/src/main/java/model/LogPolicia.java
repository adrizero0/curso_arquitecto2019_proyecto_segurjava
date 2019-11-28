package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the log_policia database table.
 * 
 */
@Entity
@Table(name="log_policia")
@NamedQuery(name="LogPolicia.findAll", query="SELECT l FROM LogPolicia l")
public class LogPolicia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLogPolicia;

	private String codpostal;

	private String direccion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechahora;

	private String poblacion;

	private String provincia;

	public LogPolicia() {
	}

	public int getIdLogPolicia() {
		return this.idLogPolicia;
	}

	public void setIdLogPolicia(int idLogPolicia) {
		this.idLogPolicia = idLogPolicia;
	}

	public String getCodpostal() {
		return this.codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public String getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}