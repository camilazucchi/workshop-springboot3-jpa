package com.project.course.services;

import com.project.course.entities.User;
import com.project.course.repositories.UserRepository;
import com.project.course.resources.exceptions.ResourceExceptionHandler;
import com.project.course.resources.exceptions.StandardError;
import com.project.course.services.exceptions.DatabaseException;
import com.project.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /* Este método recebe um objeto do tipo "User", o salva no banco de dados usando um repositório e depois retorna
     * o objeto "User" salvo. */
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    /* Este método deleta um usuário do banco de dados. */
    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            try {
                userRepository.deleteById(id);
            } catch (DataIntegrityViolationException e) {
                throw new DatabaseException(e.getMessage());
            }
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    public User updateUser(Long id, User user) {
        try {
            User entity = userRepository.getReferenceById(id);
            /* A função básica do método "getReferenceById" é retornar uma referência para uma entidade no banco de dados
             * com base no seu identificador único (ID), sem realmente acessar o banco de dados. Em outras palavras, ele
             * cria um proxy para a entidade desejada, sem carregar todos os seus dados do banco de dados. */
            updateData(entity, user);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
