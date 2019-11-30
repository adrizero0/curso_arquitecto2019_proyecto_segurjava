package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoPolicia;
import model.LogPolicia;

@Service("sPolicia")
public class ServicePoliciaImpl implements ServicePolicia {
	@Autowired
	DaoPolicia daoPolicia;
	
	@Override
	public void guardarRegistroAlarma(LogPolicia log) {		
		daoPolicia.save(log);			
		System.out.println("La policía va en camino.");
	}
}
