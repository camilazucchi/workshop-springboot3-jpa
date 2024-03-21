package com.project.course.resources;

import com.project.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* A anotação "@RestController" é uma anotação específica do Spring Framework em Java, geralmente usada em aplicativos
 * web para definir controladores que tratam solicitações HTTP e retornam respostas HTTP, especialmente em aplicações
 * RESTful. */
@RequestMapping(value = "/users")
/* A anotação "@RequestMapping" é usada para mapear um endpoint específico em uma classe controladora (como uma classe
 * marcada com "@RestController") para uma determinada URL. */
public class UserResource {

    /* Este método é um exemplo de um controlador em uma aplicação Spring que retorna todos os usuários existentes.
     * Ele retorna um objeto do tipo "ResponseEntity<User>", isso significa que ele retorna uma resposta HTTP contendo
     * um objeto do tipo "User".
     * O trecho "return ResponseEntity.ok().body(user)" é responsável por construir e retornar a resposta HTTP.
     * - "ResponseEntity.ok()": este método estático da classe "ResponseEntity" cria uma instância de "ResponseEntity"
     * com o status HTTP 200 OK. Isso indica que a solicitação foi bem-sucedida.
     * - ".body(user)": define o corpo da resposta com o objeto "user" criado anteriormente. Neste caso, o objeto "User"
     * será serializado para o corpo da resposta no formato JSON (ou XML, dependendo da configuração). */
    @GetMapping
    /* A anotação "@GetMapping" define uma rota que responde a requisições HTTP GET. */
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Maria", "maria@gmail.com", "55 48999325674", "12345");
        return ResponseEntity.ok().body(user);
    }

}
