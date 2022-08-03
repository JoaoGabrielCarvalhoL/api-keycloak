package br.com.carv.apikeycloak.service;

import br.com.carv.apikeycloak.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    Page<User> findByEmail(String email);

    Page<User> findByName(String name);

    User findById(Long id);

    List<User> findAll();

    void delete(Long id);

    void save(User user);

    void update(User user);

    User getUserByUsername(String username);


}

