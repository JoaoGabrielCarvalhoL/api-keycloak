package br.com.carv.apikeycloak.repository;

import br.com.carv.apikeycloak.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
