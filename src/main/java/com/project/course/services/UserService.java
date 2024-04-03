package com.project.course.services;

import com.project.course.entities.User;
import com.project.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* Este método retorna uma lista de todos os usuários presentes no banco de dados. Ele faz isso chamando o método
     * "findAll()" do "UserRepository", que é uma interface fornecida pelo Spring Data JPA. */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /* O tipo "Optional" foi introduzido no Java para lidar de forma mais segura e expressiva com valores que podem
     * estar ausentes. Ele permite indicar explicitamente que um valor pode estar presente ou ausente, evitando assim
     * exceções de "NullPointerException". */
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    /* Este método recebe um objeto do tipo "User", o salva no banco de dados usando um repositório e depois retorna
     * o objeto "User" salvo. */
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    /* Este método deleta um usuário do banco de dados. */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
