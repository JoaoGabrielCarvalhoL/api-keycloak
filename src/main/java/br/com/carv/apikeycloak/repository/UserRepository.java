package br.com.carv.apikeycloak.repository;

import br.com.carv.apikeycloak.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.name LIKE %:name%")
    Page<User> findUserByName(String name, Pageable pageable);

    @Query(value = "SELECT u FROM User u WHERE u.email LIKE %:email%")
    Page<User> findUserByEmail(String email, Pageable pageable);

    User findByUsername(String username);
}
