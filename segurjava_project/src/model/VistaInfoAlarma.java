package model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.annotation.Immutable;

import java.util.Date;


/**
 * The persistent class for the vista_info_alarmas database table.
 * 
 */
@Entity
@Table(name="vista_info_alarmas")
@Immutable
@NamedQuery(name="VistaInfoAlarma.findAll", query="SELECT v FROM VistaInfoAlarma v")
public class VistaInfoAlarma implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlarma;

	private int idSensor;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	
	private String ubicacion;

	private String direccion;

	private String poblacion;

	private String provincia;

	private String codpostal;

	private int idContrato;

	private String dni;
	
	private String nombre;

	private String apellidos;

	public VistaInfoAlarma() {
	}

	
	public VistaInfoAlarma(int idAlarma, int idSensor, Date fechaHora, String ubicacion, String direccion,
			String poblacion, String provincia, String codpostal, int idContrato, String dni, String nombre,
			String apellidos) {
		super();
		this.idAlarma = idAlarma;
		this.idSensor = idSensor;
		this.fechaHora = fechaHora;
		this.ubicacion = ubicacion;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.codpostal = codpostal;
		this.idContrato = idContrato;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}


	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getIdAlarma() {
		return this.idAlarma;
	}

	public void setIdAlarma(int idAlarma) {
		this.idAlarma = idAlarma;
	}

	public int getIdContrato() {
		return this.idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public int getIdSensor() {
		return this.idSensor;
	}

	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}