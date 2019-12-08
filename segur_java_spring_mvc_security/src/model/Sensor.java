package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private byte modo;

	private String ubicacion;

	//bi-directional many-to-one association to Alarma
	@OneToMany(mappedBy="sensor")
	private List<Alarma> alarmas;

	//bi-directional many-to-one association to Contrato
	@ManyToOne
	@JoinColumn(name="idContrato")
	private Contrato contrato;

	public Sensor() {
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

	public List<Alarma> getAlarmas() {
		return this.alarmas;
	}

	public void setAlarmas(List<Alarma> alarmas) {
		this.alarmas = alarmas;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}