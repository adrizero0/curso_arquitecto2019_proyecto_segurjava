package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Contrato;
import model.VistaInfoAlarma;

public interface DaoContratos extends JpaRepository<Contrato, Integer> {
	@Query(value = "SELECT c FROM Contrato c WHERE c.cliente.dni =?1")
	List<Contrato> findContratoByDni(String dni);

}
