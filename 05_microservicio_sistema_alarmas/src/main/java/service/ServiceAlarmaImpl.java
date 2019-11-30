package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoAlarma;
import model.Alarma;
import model.LogPoliciaPojo;
import model.LogPolicia;
import model.Sensor;

@Service("sAlarma")
public class ServiceAlarmaImpl implements ServiceAlarma {
	@Autowired
	DaoAlarma daoAlarma;
	
	@Autowired
	ServiceSensor sSensor;

	
	@Transactional
	@Override
	public String guardarRegistroAlarma(Alarma alarma) {
		if(alarma.getSensor().getEstado()!=(byte)0) {
			daoAlarma.save(alarma);		
			sSensor.cambiarModoSensor(alarma.getSensor().getIdSensor());
			llamadoPropietario(alarma.getSensor());
			
			if(alarma.getSensor().getContrato().getAvisoPolicia()==(byte)1) {
				return "logPolicia";
			}			
		}return "propietario";
	}

	@Override
	public void llamadoPropietario(Sensor sensor) {
		String telefono= sensor.getContrato().getCliente().getTelefono();		
		System.out.println("Salto de alarma en dirección "+sensor.getContrato().getDireccion()+": Se avisará al propietario al número "+telefono); 
	}

	@Override
	public LogPolicia llamadoPolicia(Alarma alarma) {
		LogPolicia log=new LogPolicia (0, alarma.getSensor().getContrato().getCodpostal(),
													alarma.getSensor().getContrato().getDireccion(),
													alarma.getFechaHora(),
													alarma.getSensor().getContrato().getPoblacion(),
													alarma.getSensor().getContrato().getProvincia());
		return log;
	}

	@Override
	public Alarma getAlarmaByIdSensor(int idSensor) {
		Alarma alarma= new Alarma (0, new Date(), sSensor.obtenersensor(idSensor));
		return alarma;
	}	
}
