package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoAlarma;
import daos.DaoContrato;
import daos.DaoSensor;
import model.Alarma;
import model.Contrato;
import model.LogPoliciaPojo;
import model.Sensor;

@Service("sAlarma")
public class ServiceAlarmaImpl implements ServiceAlarma {
	@Autowired
	DaoAlarma daoAlarma;
	
	@Autowired
	DaoContrato daoContrato;
	
	@Autowired
	DaoSensor daoSensor;
	
	@Autowired
	ServiceSensor sSensor;

	
	@Transactional
	@Override
	public String guardarRegistroAlarma(Alarma alarma) {
		int idSensor=alarma.getIdSensor();
		Sensor sensor=daoSensor.findById(idSensor).orElse(null);
		Contrato contrato=daoContrato.findById(sensor.getIdContrato()).orElse(null);
		
		if(sensor.getEstado()!=(byte)0) {
			daoAlarma.save(alarma);
			sSensor.cambiarModoSensorAlarma(idSensor);
			llamadoPropietario(sensor);
			
			if(contrato.getAvisoPolicia()==(byte)1) {
				System.out.println(contrato.getAvisoPolicia()+"= Entramos a al if del service alarma");
				return "logPolicia";
			}			
		}return "propietario";
	}

	@Override
	public void llamadoPropietario(Sensor sensor) {
		Contrato contrato=daoContrato.findById(sensor.getIdContrato()).orElse(null);
		String telefono= contrato.getCliente().getTelefono();
		System.out.println("Salto de alarma en dirección "+contrato.getDireccion()+": Se avisará al propietario al número "+telefono); 
	}

	@Override
	public Alarma crearAlarmaByIdSensor(int idSensor) {
		Alarma alarma= new Alarma (0, new Date(), idSensor);
		return alarma;
	}	
	
	@Override
	public LogPoliciaPojo llamadoPolicia(Alarma alarma) {
		Sensor sensor=daoSensor.findById(alarma.getIdSensor()).orElse(null);
		Contrato contrato=daoContrato.findById(sensor.getIdContrato()).orElse(null);
		LogPoliciaPojo log=new LogPoliciaPojo (0, contrato.getCodpostal(),
													contrato.getDireccion(),
													new Date(),
													contrato.getPoblacion(),
													contrato.getProvincia());
		return log;
	}
	
	
	
}
