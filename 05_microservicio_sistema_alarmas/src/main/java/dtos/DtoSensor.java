package dtos;

public class DtoSensor {
	
	private int idSensor;

	private byte estado;

	private byte modo;

	private String ubicacion;

	private int idContrato;
	
	private String dni;

	public DtoSensor() {
		super();
	}

	public DtoSensor(int idSensor, byte estado, byte modo, String ubicacion, int idContrato, String dni) {
		super();
		this.idSensor = idSensor;
		this.estado = estado;
		this.modo = modo;
		this.ubicacion = ubicacion;
		this.idContrato = idContrato;
		this.dni = dni;
	}

	public int getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public byte getModo() {
		return modo;
	}

	public void setModo(byte modo) {
		this.modo = modo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
