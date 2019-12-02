package service;

import model.Role;
import model.Usuario;

public interface ServiceLogin {
	boolean autenticar(String usuario, String password);
	String autorizar(Usuario usuario, Role role);
}
