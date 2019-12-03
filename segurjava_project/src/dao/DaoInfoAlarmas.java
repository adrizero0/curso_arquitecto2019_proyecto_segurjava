package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.VistaInfoAlarma;

public interface DaoInfoAlarmas extends JpaRepository<VistaInfoAlarma, Integer> {

	@Query(value = "SELECT DISTINCT v.dni FROM VistaInfoAlarma v")
	List<String> findAllDniWithAlarm();
	
	@Query(value = "SELECT v FROM VistaInfoAlarma v WHERE v.dni = ?1")
	List<VistaInfoAlarma> findAllByDni(String dni);
	
	@Query(value = "SELECT v FROM VistaInfoAlarma v WHERE v.fechaHora BETWEEN ?1 AND ?2")
	List<VistaInfoAlarma> getAllBetweenDates(Date fechaDesde, Date fechaHasta);
}
