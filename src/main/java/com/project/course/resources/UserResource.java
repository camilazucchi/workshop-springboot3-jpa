package com.project.course.resources;

import com.project.course.entities.User;
import com.project.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        Optional<User> object = Optional.ofNullable(service.findById(id));
        return ResponseEntity.ok().body(object);
    }

    /* Para inserir um novo recurso no banco de dados, utilizamos o método POST do HTTP! */
    @PostMapping
    /* A anotação "@PostMapping" é utilizada para mapear solicitações POST para métodos específicos em classes de
     * controle no Spring Framework. */
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        user = service.insertUser(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        /* A linha de código acima serve para criar um URI para o novo usuário que foi inserido.
         * "ServletUriComponentBuilder" é uma classe do Spring que ajuda a construir URIs a partir das informações
         * da solicitação atual. Neste caso, está sendo utilizado o URI da solicitação e adicionando "/{id}" ao final.
         * Em ".buildAndExpand(user.getId())" é adicionado o ID do novo usuário à URI. Isso significa que a URI do
         * usuário terá o formato "/users/{id}", onde "{id}" será o ID do usuário recém-criado.
         * Já o método "toUri()" converte a URI construída em um objeto URI. */
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    /* A resposta dessa requisição não irá nos retornar nenhum corpo, por isso, utilizamos "void"! */
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        /* O código HTTP de uma resposta que não possui conteúdo é o 204! */
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user = service.updateUser(id, user);
        return ResponseEntity.ok().body(user);
    }


}
