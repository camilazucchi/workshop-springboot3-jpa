package com.project.course.resources;

import com.project.course.entities.User;
import com.project.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/* A anotação "@RestController" é uma anotação específica do Spring Framework em Java, geralmente usada em aplicativos
 * web para definir controladores que tratam solicitações HTTP e retornam respostas HTTP, especialmente em aplicações
 * RESTful. */
@RequestMapping(value = "/users")
/* A anotação "@RequestMapping" é usada para mapear um endpoint específico em uma classe controladora (como uma classe
 * marcada com "@RestController") para uma determinada URL. */
public class UserResource {

    private final UserService service;

    @Autowired
    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    /* A anotação "@GetMapping" define uma rota que responde a requisições HTTP GET.
     * Para recuperar dados do banco de dados, utilizamos o método GET do HTTP! */
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        Optional<User> object = service.findById(id);
        return ResponseEntity.ok().body(object);
    }

    /* Para inserir um novo recurso no banco de dados, utilizamos o método POST do HTTP! */
    @PostMapping
    /* A anotação "@PostMapping" é utilizada para mapear solicitações POST para métodos específicos em classes de
     * controle no Spring Framework. */
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        user = service.insertUser(user);
        return ResponseEntity.ok().body(user);
    }


}
