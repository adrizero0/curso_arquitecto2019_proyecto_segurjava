package service;

import model.Alarma;
import model.LogPoliciaPojo;
import model.Sensor;

public interface ServiceAlarma {
	String guardarRegistroAlarma(Alarma alarma);
	void llamadoPropietario(Sensor sensor);
	Alarma crearAlarmaByIdSensor(int idSensor);
	LogPoliciaPojo llamadoPolicia(Alarma alarma);

}
