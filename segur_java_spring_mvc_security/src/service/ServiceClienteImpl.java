package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoClientes;
import daos.DaoContratos;
import model.Cliente;
import model.Contrato;

@Service(value = "serviceCliente")
public class ServiceClienteImpl implements ServiceCliente {
	
	@Autowired
	DaoContratos daoContratos;
	
	@Autowired
	DaoClientes daoClientes;
	
	@Override
	public List<Contrato> obtenerListaContratos(String dni) {		
		return daoContratos.findContratoByDni(dni);
	}

	@Override
	public Cliente obtenerClienteByDni(String dni) {		
		return daoClientes.findById(dni).orElse(null);
	}

}
