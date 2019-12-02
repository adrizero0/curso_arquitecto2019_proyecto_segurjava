package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;

public interface DaoClientes extends JpaRepository<Cliente, String> {

}
