package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dtos.DtoSensor;
import model.Sensor;
import reactor.core.publisher.Flux;
import service.ServiceSensor;

@CrossOrigin(origins = "*")
@RestController
public class SensorController {
	@Autowired
	ServiceSensor sSensor;
	
	@GetMapping (value = "/lista/{idContrato}", produces="text/event-stream")
	public Flux<List<DtoSensor>> obtenerSensoresIdContrato(@PathVariable("idContrato") int idContrato) {
		return Flux.create(fs->{
			List<DtoSensor> anterior=null;
			List<DtoSensor> listaDto=new ArrayList<>();
			while(true) {
				List<Sensor> lista=sSensor.getSensoresByIdContrato(idContrato);
				
				for(Sensor l:lista) {
					DtoSensor dtoSensor= new DtoSensor(l.getIdSensor(),
														l.getEstado(),
														l.getModo(),
														l.getUbicacion(),
														l.getContrato().getIdContrato(),
														l.getContrato().getCliente().getDni());
					listaDto.add(dtoSensor);
				}				
				
				if(cambio(anterior,listaDto)) {
					fs.next(listaDto);
				}
				anterior=listaDto;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}								
			}			
		});
	}
	
	@GetMapping (value = "/lista/{dni}", produces="text/event-stream")
	public Flux<List<DtoSensor>> obtenerSensoresDni(@PathVariable("dni") int dni) {
		return Flux.create(fs->{
			List<DtoSensor> anterior=null;
			List<DtoSensor> listaDto=new ArrayList<>();
			
			while(true) {
				List<Sensor> lista=sSensor.getSensoresByDni(dni);				
				for(Sensor l:lista) {
					DtoSensor dtoSensor= new DtoSensor(l.getIdSensor(),
														l.getEstado(),
														l.getModo(),
														l.getUbicacion(),
														l.getContrato().getIdContrato(),
														l.getContrato().getCliente().getDni());
					listaDto.add(dtoSensor);
				}				
				
				if(cambio(anterior,listaDto)) {
					fs.next(listaDto);
				}
				anterior=listaDto;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}								
			}			
		});
	}
	
	private boolean cambio(List<DtoSensor> anterior,List<DtoSensor> actual ) {		
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
		
	@GetMapping(value = "/cambiarmodo/{idSensor}")
	public void cambiarModoSensor(@PathVariable("idSensor") int idSensor){
		sSensor.cambiarModoSensor(idSensor);		
	}	
	
	
	
	
}