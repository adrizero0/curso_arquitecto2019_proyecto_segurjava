package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import service.ServiceCliente;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String dni;
	private String password;
	
	@ManagedProperty("#{serviceCliente}")
	ServiceCliente sCliente;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ServiceCliente getsCliente() {
		return sCliente;
	}

	public void setsCliente(ServiceCliente sCliente) {
		this.sCliente = sCliente;
	}
	
	public String entrar() {
		if(sCliente.validar(dni, password)!=null) {
			if(sCliente.autorizar(dni, password).contentEquals("ROLE_ADMIN")) {
				return "admin";
			}else {
				return "cliente";
			}
		}else {
			return null;
		}
	}

}
