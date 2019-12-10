package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoClientes;
import daos.DaoContratos;
import daos.DaoSensores;
import model.Cliente;
import model.Contrato;
import model.Sensor;

@Service(value = "serviceCliente")
public class ServiceClienteImpl implements ServiceCliente {
	
	@Autowired
	DaoContratos daoContratos;
	
	@Autowired
	DaoClientes daoClientes;
	
	@Autowired
	DaoSensores daoSensores;
	
	@Override
	public List<Contrato> obtenerListaContratos(String dni) {		
		return daoContratos.findContratoByDni(dni);
	}

	@Override
	public Cliente obtenerClienteByDni(String dni) {		
		return daoClientes.findById(dni).orElse(null);
	}

	@Override
	public List<Sensor> obtenerListaSensores(int idContrato) {
		return daoSensores.findSensorByIdContrato(idContrato);
	}

	@Override
	public Contrato obtenerContratoByIdSensor(int idSensor) {
		Sensor sensor= daoSensores.findById(idSensor).orElse(null);
		int idContrato= sensor.getIdContrato();
		return daoContratos.findById(idContrato).orElse(null);
	}

}
