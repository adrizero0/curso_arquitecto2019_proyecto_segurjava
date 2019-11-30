package controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.LogPolicia;
import service.ServicePolicia;

@CrossOrigin(origins = "*")
@RestController
public class AlarmaController {
	@Autowired
	ServicePolicia sPolicia;	

	@Transactional
	@PutMapping(value = "/intruso/{codpostal}/{direccion}/{fechahora}/{poblacion}/{provincia}/")
	public void saltoDeAlarma(@PathVariable("codpostal") String codpostal,
								@PathVariable("direccion") String direccion,
								@PathVariable("fechahora") Date fechahora,
								@PathVariable("poblacion") String poblacion,
								@PathVariable("provincia") String provincia){
		LogPolicia log=new LogPolicia(0,codpostal,direccion,fechahora,poblacion,provincia);
		sPolicia.guardarRegistroAlarma(log);
		System.out.println("Fueron guardados los datos en la policía.");
	}	
}
