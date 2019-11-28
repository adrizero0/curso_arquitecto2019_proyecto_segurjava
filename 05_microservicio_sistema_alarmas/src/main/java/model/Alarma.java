package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	@JoinColumn(name="idSensor")
	private Sensor sensor;

	public Alarma() {
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