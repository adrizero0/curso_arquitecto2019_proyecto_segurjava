package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Contrato;

public interface DaoContrato extends JpaRepository<Contrato, Integer> {
}
