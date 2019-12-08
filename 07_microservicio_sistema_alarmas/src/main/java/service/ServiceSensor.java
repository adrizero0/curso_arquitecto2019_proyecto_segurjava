package service;

import java.util.List;

import model.Sensor;

public interface ServiceSensor {
	List<Sensor> getSensoresByIdContrato(int idContrato);
	void cambiarModoSensor(int idSensor);
	Sensor obtenerSensor(int idSensor);
	void cambiarModoSensorAlarma(int idSensor);
}