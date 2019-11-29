package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Contrato;

public interface DaoContratos extends JpaRepository<Contrato, Integer> {

}
