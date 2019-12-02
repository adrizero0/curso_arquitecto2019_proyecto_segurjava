package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoClientes;
import dao.DaoContratos;
import dao.DaoInfoAlarmas;
import dao.DaoSensores;
import model.Cliente;
import model.Contrato;
import model.Sensor;
import model.VistaInfoAlarma;
import varconst.ConstGenerales;

@Service(value = "serviceAdmin")
public class ServiceAdministraciónImpl implements ServiceAdministracion {

	@Autowired
	DaoClientes daoClientes;
	
	@Autowired
	DaoContratos daoContratos;
	
	@Autowired
	DaoSensores daoSensores;
	
	@Autowired
	DaoInfoAlarmas daoInfoAlarmas;
	
	@Override
	public Cliente obtenerDatosCliente(String dni) {
		return daoClientes.findById(dni).orElse(null);
	}

	@Transactional
	@Override
	public void altaCliente(Cliente cliente) {
		if(cliente!=null) {
			daoClientes.saveAndFlush(cliente);
		} else {
			throw new NullPointerException("Alta cliente"); 
		}

	}

	@Transactional
	@Override
	public void actDatosCliente(Cliente cliente) {
		if(cliente!=null) {
			daoClientes.save(cliente);
		} else {
			throw new NullPointerException("Actualizar cliente"); 
		}

	}

	@Transactional
	@Override
	public void bajaCliente(String dni) {
		Cliente cliente = obtenerDatosCliente(dni);
		if(cliente!=null) {
			bajaCliente(cliente);
		}

	}

	@Transactional
	@Override
	public void bajaCliente(Cliente cliente) {
		if (cliente==null) {
			throw new NullPointerException("Baja cliente");
		}

		if (cliente.getEstado()==ConstGenerales.ALTA) {
		
			cliente.getContratos().forEach(contrato -> bajaContrato(contrato));
			cliente.setEstado(ConstGenerales.BAJA);
			actDatosCliente(cliente);
		} //ConstGenerales.ALTA
		
	}

	@Override
	public Contrato obtenerContrato(int idContrato) {
		return daoContratos.findById(idContrato).orElse(null);
	}

	@Transactional
	@Override
	public void altaContrato(Contrato contrato) {
		if(contrato!=null) {
			daoContratos.saveAndFlush(contrato);
		} else {
			throw new NullPointerException("Alta contrato"); 
		}

	}

	@Transactional
	@Override
	public void actDatosContrato(Contrato contrato) {
		if(contrato!=null) {
			daoContratos.save(contrato);
		} else {
			throw new NullPointerException("Actualizar contrato"); 
		}
	}

	@Transactional
	@Override
	public void bajaContrato(int idContrato) {
		Contrato contrato = obtenerContrato(idContrato);
		if (contrato!=null) {
			bajaContrato(contrato);
		}
	}

	@Transactional
	@Override
	public void bajaContrato(Contrato contrato) {
		if (contrato==null) {
			throw new NullPointerException("Baja contrato");
		}

		if (contrato.getEstado()==ConstGenerales.ALTA) {
		
			contrato.getSensores().forEach(sensor -> bajaSensor(sensor));
			contrato.setEstado(ConstGenerales.BAJA);
			actDatoscontrato(contrato);
		} //ConstGenerales.ALTA

	}

	@Override
	public Sensor obtenerSensor(int idSensor) {
		return daoSensores.findById(idSensor).orElse(null);
	}

	@Transactional
	@Override
	public void altaSensor(Sensor sensor) {
		if(sensor!=null) {
			daoSensores.saveAndFlush(sensor);
		} else {
			throw new NullPointerException("Alta sensor"); 
		}

	}

	@Transactional
	@Override
	public void actDatosSensor(Sensor sensor) {
		if(sensor!=null) {
			daoSensores.save(sensor);
		} else {
			throw new NullPointerException("Actualizar sensor"); 
		}

	}

	@Transactional
	@Override
	public void bajaSensor(int idSensor) {
		Sensor sensor = obtenerSensor(idSensor);
		if (sensor!=null) {
			bajaSensor(sensor);
		}

	}

	@Override
	public void bajaSensor(Sensor sensor) {
		if (sensor==null) {
			throw new NullPointerException("Baja sensor");
		}

		sensor.setEstado(ConstGenerales.OFF);
		sensor.setModo(ConstGenerales.MODO_NORMAL);
		
		actDatosSensor(sensor);

	}

	@Override
	public List<String> obtenerListaClientesConAlarmas(){
		return daoInfoAlarmas.findAllDniWithAlarm();
	}
	
	
	@Override
	public List<VistaInfoAlarma> obtenerAlarmasCliente(String dni) {
		return daoInfoAlarmas.findAllByDni(dni);
	}

	@Override
	public List<VistaInfoAlarma> obtenerAlarmasRangoFechas(Date fechaDesde, Date fechaHasta) {
		return daoInfoAlarmas.getAllBetweenDates(fechaDesde, fechaHasta);
	}

	@Override
	public void actDatosAcceso(String dni, String password) {
		// TODO Auto-generated method stub

	}

}
