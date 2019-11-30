package controller;

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
import service.ServiceAlarma;

@CrossOrigin(origins = "*")
@RestController
public class AlarmaController {
	@Autowired
	ServiceAlarma sAlarma;
	
	@Value("${client.url.logpolicia}")
	String url;
	
	@Autowired
	RestTemplate template;
	
	@Transactional
	@PutMapping(value = "/intruso/{idSensor}", produces = MediaType.TEXT_PLAIN_VALUE)
	public void saltoDeAlarma(@PathVariable("idSensor") int idSensor){
		String alarma= sAlarma.guardarRegistroAlarma(sAlarma.getAlarmaByIdSensor(idSensor));
		
		if(alarma.contentEquals("logPolicia")) {
			LogPolicia policia= sAlarma.llamadoPolicia(sAlarma.getAlarmaByIdSensor(idSensor));
			template.put(url+policia.getCodpostal()+"/"+policia.getDireccion()+"/"+policia.getFechahora()+"/"
						+policia.getPoblacion()+"/"+policia.getProvincia(), null);		
			System.out.println("La policía fue reportada exitosamente.");
		}
	}	
}
