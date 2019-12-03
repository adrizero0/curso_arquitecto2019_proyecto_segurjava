package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Cliente;
import service.ServiceAdministracion;
import varconst.ConstGenerales;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	private String dni;
	private String apellidos;
	private String codpostal;
	private String direccion;
	private String iban;
	private String nombre;
	private String poblacion;
	private String provincia;
	private String telefono;
	private byte estado;	

	@ManagedProperty("#{serviceAdmin}")
	ServiceAdministracion servAdmin;

	
	public ServiceAdministracion getServAdmin() {
		return servAdmin;
	}

	public void setServAdmin(ServiceAdministracion servAdmin) {
		this.servAdmin = servAdmin;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCodpostal() {
		return codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

;	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	
	public String registrar() {
		
		  Cliente cliente = null; cliente = new Cliente("", apellidos, codpostal,
		  direccion, iban, nombre, poblacion, provincia, telefono, ConstGenerales.ALTA);
		  servAdmin.altaCliente(cliente);
		 		
  		  return "menuadmin";
	}
}
