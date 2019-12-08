package model;

import java.util.Date;



public class LogPoliciaPojo {
	
	private int idLogPolicia;

	private String codpostal;

	private String direccion;

	private Date fechahora;

	private String poblacion;

	private String provincia;

	public LogPoliciaPojo() {
	}	

	public LogPoliciaPojo(int idLogPolicia, String codpostal, String direccion, Date fechahora, String poblacion,
			String provincia) {
		this.idLogPolicia = idLogPolicia;
		this.codpostal = codpostal;
		this.direccion = direccion;
		this.fechahora = fechahora;
		this.poblacion = poblacion;
		this.provincia = provincia;
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