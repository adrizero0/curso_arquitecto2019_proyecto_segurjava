package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sensores database table.
 * 
 */
@Entity
@Table(name="sensores")
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSensor;

	private byte estado;

	private int idContrato;

	private byte modo;

	private String ubicacion;

	public Sensor() {
	}
	

	public Sensor(int idSensor, byte estado, int idContrato, byte modo, String ubicacion) {
		super();
		this.idSensor = idSensor;
		this.estado = estado;
		this.idContrato = idContrato;
		this.modo = modo;
		this.ubicacion = ubicacion;
	}


	public int getIdSensor() {
		return this.idSensor;
	}

	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public int getIdContrato() {
		return this.idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public byte getModo() {
		return this.modo;
	}

	public void setModo(byte modo) {
		this.modo = modo;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}