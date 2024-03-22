package com.project.course.config;

import com.project.course.entities.User;
import com.project.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
/* A anotação "@Configuration" é usada para definir uma ou mais configurações de beans, métodos para criar e
 * configurar beans, ou importa outras classes de configuração. */
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    /* A anotação "@Autowired" é usada para realizar a injeção de dependência automaticamente em classes gerenciadas
     * pelo Spring, como componentes, serviços, repositórios, controladores, etc.
     * Quando usamos essa anotação o Spring procura automaticamente por uma instância correspondente do tipo do campo
     * ou parâmetro e a injeta nesse ponto de injeção. */
    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* Quando a aplicação é iniciada, ela insere dois usuários no banco de dados usando o método "saveAll" do
     * "UserRepository". */
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

    }

}