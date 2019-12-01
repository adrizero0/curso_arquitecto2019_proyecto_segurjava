package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Alarma;
import model.LogPoliciaPojo;
import service.ServiceAlarma;

@CrossOrigin(origins = "*")
@RestController
public class AlarmaController {
	@Autowired
	ServiceAlarma sAlarma;
	
//	@Value("${client.url.logpolicia}")
//	String url="http://servicio-logpolicia/zuullog/alerta/intruso/";
//	String url="http://servidor-zuul:7000/servicio-logpolicia/zuullog/alerta/intruso/";
	String url="http://servicio-logpolicia/zuullog/alerta/intruso/";
	
	@Autowired
	RestTemplate template;
	
	@Transactional
	@PutMapping(value = "/intruso/{idSensor}")
	public void saltoDeAlarma(@PathVariable("idSensor") int idSensor){
		Alarma alarma=sAlarma.crearAlarmaByIdSensor(idSensor);
		String guardarAlarma= sAlarma.guardarRegistroAlarma(alarma);
		
		if(guardarAlarma.contentEquals("logPolicia")) {
			System.out.println("entramos al if de alarma controller");
			
			LogPoliciaPojo policia= sAlarma.llamadoPolicia(alarma);
			
			System.out.println(url+policia.getCodpostal()+"/"+policia.getDireccion()+"/"+policia.getPoblacion()+"/"+policia.getProvincia());
			
			template.put(url+policia.getCodpostal()+"/"+policia.getDireccion()+"/"+policia.getPoblacion()+"/"+policia.getProvincia(), null);
			
			System.out.println("La policía fue reportada exitosamente.");
		}
	}	
}
