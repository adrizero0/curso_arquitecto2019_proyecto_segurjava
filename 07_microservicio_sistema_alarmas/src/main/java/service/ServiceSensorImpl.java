package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoSensor;
import model.Sensor;

@Service("sSensor")
public class ServiceSensorImpl implements ServiceSensor {
	@Autowired
	DaoSensor daoSensor;

	@Override
	public List<Sensor> getSensoresByIdContrato(int idContrato) {
		List<Sensor> lista= daoSensor.findSensoresByIdContrato(idContrato);
		if(lista!=null) {
			return lista;
		}
		return null;
	}

	@Override
	public void cambiarModoSensor(int idSensor) {
		Sensor sensor= obtenerSensor(idSensor);
		byte modo= sensor.getModo();
		if(modo==(byte)1) {
			sensor.setModo((byte) 0);
			daoSensor.flush();
		}else {
			sensor.setModo((byte) 1);
			daoSensor.flush();
		}		
	}
	
	@Override
	public void cambiarModoSensorAlarma(int idSensor) {
		Sensor sensor= obtenerSensor(idSensor);		
		sensor.setModo((byte) 1);
		daoSensor.flush();				
	}

	@Override
	public Sensor obtenerSensor(int idSensor) {
		return daoSensor.findById(idSensor).orElse(null);
	}

	@Override
	public List<Sensor> getSensores() {
		return daoSensor.findAll();
	}
	
}