package service;

import model.Alarma;
import model.LogPoliciaPojo;
import model.Sensor;

public interface ServiceAlarma {
	String guardarRegistroAlarma(Alarma alarma);
	void llamadoPropietario(Sensor sensor);
	LogPoliciaPojo llamadoPolicia(Alarma alarma);
	Alarma crearAlarmaByIdSensor(int idSensor);
	

}
