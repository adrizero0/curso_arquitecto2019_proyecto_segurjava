package service;

import java.util.List;

import model.Cliente;
import model.Contrato;
import model.Sensor;

public interface ServiceCliente {

	List<Contrato> obtenerListaContratos(String dni);
	List<Sensor> obtenerListaSensores(int idContrato);
	Cliente obtenerClienteByDni(String dni);
	Contrato obtenerContratoByIdSensor(int idSensor);

}
