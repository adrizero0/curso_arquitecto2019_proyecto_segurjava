package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoSensor;
import dtos.DtoSensor;
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
	public List<Sensor> getSensoresByDni(int dni) {
		List<Sensor> lista= daoSensor.findSensoresByDni(dni);
		if(lista!=null) {
			return lista;
		}
		return null;
	}

	@Override
	public void cambiarModoSensor(int idSensor) {
		Sensor sensor= obtenersensor(idSensor);
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
		Sensor sensor= obtenersensor(idSensor);		
		sensor.setModo((byte) 1);
		daoSensor.flush();				
	}

	@Override
	public Sensor obtenersensor(int idSensor) {
		return daoSensor.findById(idSensor).orElse(null);
	}

	@Override
	public List<DtoSensor> getSensoresDtoByIdContrato(int idContrato) {
		List<Sensor> listaSensor= getSensoresByIdContrato (idContrato);
		List<DtoSensor> listaDto=new ArrayList<>();
		for(Sensor l:listaSensor) {
			DtoSensor dtoSensor= new DtoSensor(l.getIdSensor(),
												l.getEstado(),
												l.getModo(),
												l.getUbicacion(),
												l.getContrato().getIdContrato(),
												l.getContrato().getCliente().getDni());
			listaDto.add(dtoSensor);
			System.out.println("Entramos al for");
		}
		return listaDto;
	}
}