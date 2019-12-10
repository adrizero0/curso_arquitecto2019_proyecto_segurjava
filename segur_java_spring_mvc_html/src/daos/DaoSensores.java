package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Sensor;

public interface DaoSensores extends JpaRepository<Sensor, Integer> {
	@Query(value = "SELECT s FROM Sensor s WHERE s.idContrato=?1")
	List<Sensor> findSensorByIdContrato(int idContrato);
}
