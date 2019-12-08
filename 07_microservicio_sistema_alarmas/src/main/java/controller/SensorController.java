package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
//	@GetMapping (value = "/lista/{idContrato}", produces="text/event-stream")
//	public Flux<List<DtoSensor>> obtenerSensoresIdContrato(@PathVariable("idContrato") int idContrato) {
//		return Flux.create(fs->{
//			List<DtoSensor> anterior=null;
//			List<DtoSensor> listaDto=new ArrayList<>();
//			while(true) {
//				List<DtoSensor> lista=sSensor.getSensoresDtoByIdContrato(idContrato);
//				System.out.println("Entramos al while");
//				for(Sensor l:lista) {
//					DtoSensor dtoSensor= new DtoSensor(l.getIdSensor(),
//														l.getEstado(),
//														l.getModo(),
//														l.getUbicacion(),
//														l.getContrato().getIdContrato(),
//														l.getContrato().getCliente().getDni());
//					listaDto.add(dtoSensor);
//					System.out.println("Entramos al for");
//				}				
				
//				if(cambio(anterior,listaDto)) {
//					fs.next(listaDto);
//					System.out.println("Entramos al if");
//				}
//				anterior=lista;
//				System.out.println("Entramos al no else "+anterior);
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}								
//			}			
//		});
//	}
	

	@CrossOrigin(origins="*")
	@GetMapping (value = "/lista/{idContrato}", produces="text/event-stream")
	public Flux<List<Sensor>> obtenerSensoresIdContrato(@PathVariable("idContrato") int idContrato) { 
		return Flux.create(fs->{
			List<Sensor> anterior=null;			
			while(true) {
				List<Sensor> lista=sSensor.getSensoresByIdContrato(idContrato);
				fs.next(lista);
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