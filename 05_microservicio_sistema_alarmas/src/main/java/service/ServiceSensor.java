package service;

import java.util.List;

import model.Sensor;

public interface ServiceSensor {
	List<Sensor> getSensoresByIdContrato(int idContrato);
	List<Sensor> getSensoresByDni(int dni);
}