package service;

import java.util.Date;
import java.util.List;

import model.Cliente;
import model.Contrato;
import model.Sensor;
import model.VistaInfoAlarma;

public interface ServiceAdministracion {

	//Clientes
	Cliente obtenerDatosCliente(String dni);
	void altaCliente(Cliente cliente);
	void actDatosCliente(Cliente cliente);
	void bajaCliente(String dni);
	void bajaCliente(Cliente cliente);

	
	//Contratos
	Contrato obtenerContrato(int idContrato);
	void altaContrato(Contrato contrato);
	void actDatosContrato(Contrato contrato);
	void bajaContrato(int idContrato);
	void bajaContrato(Contrato contrato);

	//Sensores
	Sensor obtenerSensor(int idSensor);
	void altaSensor(Sensor sensor);
	void actDatosSensor(Sensor sensor);
	void bajaSensor(int idSensor);
	void bajaSensor(Sensor sensor);

	//Alarmas
	List<String> obtenerListaClientesConAlarmas();
	List<VistaInfoAlarma> obtenerAlarmasCliente(String dni);
	List<VistaInfoAlarma> obtenerAlarmasRangoFechas(Date fechaDesde, Date fechaHasta);
	
	//Login
	void actDatosAcceso(String dni, String password);
	
}
