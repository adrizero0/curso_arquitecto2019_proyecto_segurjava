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
	String url="http://servicio-logpolicia/zuullog/alerta/instruso";
	
	@Autowired
	RestTemplate template;
	
	@PutMapping(value = "/intruso/{idSensor}")
	public void saltoDeAlarma(@PathVariable("idSensor") int idSensor){		
		Alarma alarma=sAlarma.crearAlarmaByIdSensor(idSensor);
		String guardarAlarma= sAlarma.guardarRegistroAlarma(alarma);
		if(guardarAlarma.contentEquals("logPolicia")) {
			LogPoliciaPojo policia= sAlarma.llamadoPolicia(alarma);
			template.put(url+"/"+policia.getCodpostal()+"/"+policia.getDireccion()+"/"+policia.getFechahora()+"/"+policia.getPoblacion()+"/"+policia.getProvincia(), null);	
			System.out.println("La policía fue reportada exitosamente.");
		}
	}	
}
