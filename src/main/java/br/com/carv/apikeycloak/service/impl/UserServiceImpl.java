package br.com.carv.apikeycloak.service.impl;

import br.com.carv.apikeycloak.exception.UserNotFound;
import br.com.carv.apikeycloak.model.User;
import br.com.carv.apikeycloak.repository.UserRepository;
import br.com.carv.apikeycloak.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findByEmail(String email) {
        int size = 20, page = 0;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "email");
        return userRepository.findUserByEmail(email, pageRequest);
    }

    @Override
    public Page<User> findByName(String name) {
        int page = 0, size = 20;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
        return userRepository.findUserByName(name, pageRequest);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFound("User not Found! Id: " + id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(findById(id));
    }

    @Override
    public void save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public User getUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
