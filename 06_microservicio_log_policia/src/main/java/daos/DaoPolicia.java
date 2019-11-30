package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.LogPolicia;

public interface DaoPolicia extends JpaRepository<LogPolicia, Integer> {
	
}
