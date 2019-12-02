package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import service.ServiceAdministracion;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	private String usuario;
	private String password;
	
	@ManagedProperty("#{serviceAdmin}")
	ServiceAdministracion sAdmin;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ServiceAdministracion getsAdmin() {
		return sAdmin;
	}
	public void setsAdmin(ServiceAdministracion sAdmin) {
		this.sAdmin = sAdmin;
	}
	
	///////
	
	public String login() {
//		if(sAdmin.autenticar(usuario, password)) {			
//			return "menu";
//		}else {
			return "error";
//		}
	}
}
