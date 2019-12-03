package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoClientes;
import dao.DaoContratos;
import dao.DaoRoles;
import dao.DaoUsuarios;
import model.Cliente;
import model.Contrato;
import model.Role;
import model.Usuario;

@Service(value = "serviceCliente")
public class ServiceClienteImpl implements ServiceCliente {
	
	@Autowired
	DaoContratos daoContratos;
	
	@Autowired
	DaoClientes daoClientes;
	
	@Autowired
	DaoUsuarios daoUsuarios;
	
	@Autowired
	DaoRoles daoRoles;

	@Override
	public List<Contrato> obtenerListaContratos(String dni) {		
		return daoContratos.findContratoByDni(dni);
	}

	@Override
	public Cliente obtenerClienteByDni(String dni) {		
		return daoClientes.findById(dni).orElse(null);
	}

	@Override
	public Usuario obtenerPassByDni(String dni) {
		return daoUsuarios.findById(dni).orElse(null);
	}

	@Transactional
	@Override
	public Cliente validar(String dni, String password) {
		Cliente cliente=obtenerClienteByDni(dni);
		Usuario usuario=obtenerPassByDni(dni);
		if(usuario.getPassword().contentEquals(password)) {
			return cliente;
		}
		return null;
	}
	
	@Transactional
	@Override
	public String autorizar(String dni, String password) {
		Cliente cliente=validar(dni,password);
		String rol=null;
		
		if(cliente!=null) {			
			List<Role> roles= daoRoles.findAll();
			for(Role r:roles) {
				if(r.getId().getUsuario().contentEquals(dni)) {
					rol=r.getId().getRol();
				}
			}
		}
		return rol;
	}
	
	
	
	


}
