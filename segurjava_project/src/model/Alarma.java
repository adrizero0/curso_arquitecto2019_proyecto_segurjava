package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the alarmas database table.
 * 
 */
@Entity
@Table(name="alarmas")
@NamedQuery(name="Alarma.findAll", query="SELECT a FROM Alarma a")
public class Alarma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlarma;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;

	//bi-directional many-to-one association to Sensor
	@ManyToOne
	@JoinColumn(name="idSensor", referencedColumnName = "idSensor")
	private Sensor sensor;

	public Alarma() {
	}
	
	public Alarma(int idAlarma, Date fechaHora, Sensor sensor) {
		super();
		this.idAlarma = idAlarma;
		this.fechaHora = fechaHora;
		this.sensor = sensor;
	}

	public int getIdAlarma() {
		return this.idAlarma;
	}

	public void setIdAlarma(int idAlarma) {
		this.idAlarma = idAlarma;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}