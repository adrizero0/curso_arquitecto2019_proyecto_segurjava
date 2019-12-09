package service;

import java.util.List;

import model.Cliente;
import model.Contrato;

public interface ServiceCliente {

	List<Contrato> obtenerListaContratos(String dni);
	Cliente obtenerClienteByDni(String dni);

}
