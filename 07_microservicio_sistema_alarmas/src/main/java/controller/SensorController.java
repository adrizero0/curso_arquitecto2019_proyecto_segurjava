package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Sensor;
import reactor.core.publisher.Flux;
import service.ServiceSensor;

@CrossOrigin(origins = "*")
@RestController
public class SensorController {
	@Autowired
	ServiceSensor sSensor;
	
	@CrossOrigin(origins = "*")
	@GetMapping (value = "/lista2/{idContrato}", produces="text/event-stream")
	public Flux<Sensor> obtenerAcciones(@PathVariable("idContrato") int idContrato) {
		List<Sensor> lista= sSensor.getSensoresByIdContrato(idContrato);
		lista.add(new Sensor(0, (byte)0, idContrato, (byte)0, "EOF"));
		return Flux.fromIterable(lista);		
	}
	
	
	@CrossOrigin(origins="*")
	@GetMapping (value = "/lista/{idContrato}", produces="text/event-stream")
	public Flux<List<Sensor>> obtenerSensoresIdContrato(@PathVariable("idContrato") int idContrato) { 
		return Flux.create(fs->{
			List<Sensor> anterior=null;			
			while(true) {
				List<Sensor> lista=sSensor.getSensoresByIdContrato(idContrato);
				if(cambio(anterior,lista)) {
					fs.next(lista);
				}				
				anterior=lista;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		});
	}
	
	private boolean cambio(List<Sensor> anterior,List<Sensor> actual ) {		
		if(anterior==null) {
			return true;
		}else {
			for(int i=0;i<actual.size();i++) {
				if(anterior.get(i).getEstado()!=actual.get(i).getEstado()||anterior.get(i).getModo()!=actual.get(i).getModo()){
					return true;
				}
			}
		}
		return false;
	}
		
	@PutMapping(value = "/cambiarmodo/{idSensor}")
	public void cambiarModoSensor(@PathVariable("idSensor") int idSensor){
		sSensor.cambiarModoSensor(idSensor);
	}	
	
}