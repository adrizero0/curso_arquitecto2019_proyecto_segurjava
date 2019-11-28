package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Accion;
import model.Sensor;
import reactor.core.publisher.Flux;
import service.ServiceSensor;

@CrossOrigin(origins = "*")
@RestController
public class SensorController {
	@Autowired
	ServiceSensor sSensor;
	
	@GetMapping (value = "/estados/{idContrato}", produces="text/event-stream")
	public Flux<Sensor> obtenerEstadoSensores(@PathVariable("idContrato") int idContrato) {
		return Flux.create(fs->{
			List<Sensor> anterior=null;
			while(true) {
				List<Sensor> lista=sSensor.
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
	private boolean cambio(List<Accion> anterior,List<Accion> actual ) {
		
		if(anterior==null) {
			return true;
		}else {
			for(int i=0;i<actual.size();i++) {
				if(anterior.get(i).getValor()!=actual.get(i).getValor()){
					return true;
				}
			}
		}
		return false;
	}
}