package service;

import model.Alarma;
import model.LogPolicia;
import model.Sensor;

public interface ServiceAlarma {
	String guardarRegistroAlarma(Alarma alarma);
	void llamadoPropietario(Sensor sensor);
	LogPolicia llamadoPolicia(Alarma alarma);
	Alarma getAlarmaByIdSensor(int idSensor);

}
