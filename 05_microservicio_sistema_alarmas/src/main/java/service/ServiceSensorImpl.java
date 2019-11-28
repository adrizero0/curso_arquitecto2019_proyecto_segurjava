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
		return daoSensor.findSensoresByIdContrato(idContrato);
	}

	@Override
	public List<Sensor> getSensoresByDni(int dni) {
		return null;
	}
}
