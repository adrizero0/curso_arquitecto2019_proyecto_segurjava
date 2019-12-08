package model;

import java.util.ArrayList;
import java.util.List;

public class SensoresLista {
	private List<SensorPojo> sensoresLista;
	
	public SensoresLista() {
		sensoresLista = new ArrayList<>();
    }

	public SensoresLista(List<SensorPojo> sensoresLista) {
		super();
		this.sensoresLista = sensoresLista;
	}

	public List<SensorPojo> getSensoresLista() {
		return sensoresLista;
	}

	public void setSensoresLista(List<SensorPojo> sensoresLista) {
		this.sensoresLista = sensoresLista;
	}
	
	
}