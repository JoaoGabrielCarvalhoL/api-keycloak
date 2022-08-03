package br.com.carv.apikeycloak.service.impl;

import br.com.carv.apikeycloak.model.User;
import br.com.carv.apikeycloak.model.UserBuilder;
import br.com.carv.apikeycloak.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;



@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    public UserService userService;

    @Test
    public void should_crete_user_builder() {
        User user = UserBuilder.builder()
                .name("Joao Gabriel Carvalho")
                .email("27.joaogabriel@gmail.com")
                .username("joao")
                .password("123")
                .build();

        Assertions.assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void should_save_user() {
        User user = UserBuilder.builder()
                .name("Joao Gabriel Carvalho")
                .email("27.joaogabriel@gmail.com")
                .username("joao")
                .password("123")
                .build();

        userService.save(user);
        Assertions.assertNotNull(user);
    }

    @Test
    public void should_find_by_user() {
        User user = userService.findById(1L);
        Assertions.assertNotNull(user);
    }

    @Test
    public void should_update_user() {
        User user = userService.findById(1L);
        user.setPassword("123456789");
        userService.update(user);
    }

    @Test
    public void should_find_by_name() {
        Page<User> users = userService.findByName("Joao");
        Assertions.assertNotNull(users);
    }

    @Test
    public void should_find_by_email() {
        Page<User> users = userService.findByEmail("gmail");
        Assertions.assertNotNull(users);
    }

    @Test
    public void should_delete_user_by_id() {
        userService.delete(2L);
    }
}
