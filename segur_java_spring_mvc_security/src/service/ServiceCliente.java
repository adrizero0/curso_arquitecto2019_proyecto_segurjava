package service;

import java.util.List;

import model.Cliente;
import model.Contrato;
import model.Role;
import model.Usuario;

public interface ServiceCliente {

	List<Contrato> obtenerListaContratos(String dni);
	Cliente obtenerClienteByDni(String dni);
	Usuario obtenerUsuarioByDni(String dni);
	Cliente validar(String dni, String password);
	String autorizar(String dni, String password);
}
