package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Alarma;

public interface DaoAlarma extends JpaRepository<Alarma, Integer> {

}
