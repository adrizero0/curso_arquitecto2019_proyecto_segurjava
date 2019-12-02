package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Role;
import model.RolePK;

public interface DaoRoles extends JpaRepository<Role, RolePK> {

}
