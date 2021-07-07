package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuario;

public interface DaoUsuarios extends JpaRepository<Usuario, String> {

}
