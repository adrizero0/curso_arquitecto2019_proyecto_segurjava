package model;

import java.util.List;

public class SensorPojo {

	private int idSensor;

	private byte estado;

	private byte modo;

	private String ubicacion;

	private List<Alarma> alarmas;

	private Contrato contrato;

	public SensorPojo() {
	}

	public SensorPojo(int idSensor, byte estado, byte modo, String ubicacion, Contrato contrato) {
		super();
		this.idSensor = idSensor;
		this.estado = estado;
		this.modo = modo;
		this.ubicacion = ubicacion;
		this.contrato = contrato;
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