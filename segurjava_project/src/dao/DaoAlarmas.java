package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alarma;

public interface DaoAlarmas extends JpaRepository<Alarma, Integer> {

	@Query(value = "SELECT a FROM Alarma a WHERE a.fechaHora BETWEEN ?1 AND ?2")
	List<Alarma> getAllBetweenDates(Date fechaDesde, Date fechaHasta);
}
