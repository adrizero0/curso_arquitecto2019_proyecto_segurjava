package model;

public class SensorPojo {
	
	private int idSensor;

	private byte estado;

	private int idContrato;

	private byte modo;

	private String ubicacion;

	public SensorPojo() {
	}
	
	public SensorPojo(int idSensor, byte estado, int idContrato, byte modo, String ubicacion) {
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