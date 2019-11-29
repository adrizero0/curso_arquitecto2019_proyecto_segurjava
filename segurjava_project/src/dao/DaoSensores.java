package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Sensor;

public interface DaoSensores extends JpaRepository<Sensor, Integer> {

}
