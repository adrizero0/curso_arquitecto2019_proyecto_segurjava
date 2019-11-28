package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Sensor;

public interface DaoSensor extends JpaRepository<Sensor, Integer> {
	@Query("Select s From Sensor s Where s.contrato.idContrato=?1")
	List<Sensor> findSensoresByIdContrato(int idContrato);
	
	@Query("Select s From Sensor s Where s.contrato.cliente.dni=?1")
	List<Sensor> findSensoresByDni(int dni);
	
}
