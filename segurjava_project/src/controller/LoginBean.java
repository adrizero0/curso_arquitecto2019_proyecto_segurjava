package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import service.ServiceAdministracion;
import service.ServiceLogin;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	private String usuario;
	private String password;
	
	
	@ManagedProperty("#{serviceLogin}")
	ServiceLogin sLogin;
	
	
	
	///////
	
	public String login() {
//		if(sAdmin.autenticar(usuario, password)) {			
//			return "menu";
//		}else {
			return "error";
//		}
	}
}
