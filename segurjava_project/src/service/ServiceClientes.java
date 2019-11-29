package service;

import java.util.List;

import model.Alarma;
import model.Cliente;
import model.Contrato;
import model.Sensor;

public interface ServiceClientes {

	//Clientes
	Cliente obtenerDatosCliente(String dni);
	void nuevoCliente(Cliente cliente);
	void actDatosCliente(Cliente cliente);
	void bajaCliente(String dni);
	void bajaCliente(Cliente cliente);
	
	//Contratos
	Contrato obtenerContrato(int idContrato);
	void nuevoContrato(Contrato contrato);
	void actDatosContrato(Contrato contrato);
	void bajaContrato(int idContrato);
	void bajaContrato(Contrato contrato);

	//Sensores
	void bajaSensoresCliente(String dni);
	void bajaSensoresCliente(Cliente cliente);
	void bajaSensoresContrato(int idContrato);
	void bajaSensoresContrato(Contrato contrato);
	void bajaSensor(int idSensor);
	void bajaSensor(Sensor sensor);

	//Alarmas
	List<Alarma> obtenerAlarmasCliente(String dni);
	
}
