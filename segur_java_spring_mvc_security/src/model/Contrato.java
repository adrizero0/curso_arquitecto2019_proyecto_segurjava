package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the contratos database table.
 * 
 */
@Entity
@Table(name="contratos")
@NamedQuery(name="Contrato.findAll", query="SELECT c FROM Contrato c")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContrato;

	private byte avisoPolicia;

	private String codpostal;

	private String direccion;

	private byte estado;

	private String poblacion;

	private String provincia;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente",referencedColumnName = "dni")
	private Cliente cliente;

	public Contrato() {
	}

	public int getIdContrato() {
		return this.idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public byte getAvisoPolicia() {
		return this.avisoPolicia;
	}

	public void setAvisoPolicia(byte avisoPolicia) {
		this.avisoPolicia = avisoPolicia;
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

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}