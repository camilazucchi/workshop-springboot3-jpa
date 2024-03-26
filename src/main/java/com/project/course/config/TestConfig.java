package com.project.course.config;

import com.project.course.entities.Category;
import com.project.course.entities.Order;
import com.project.course.entities.User;
import com.project.course.enums.OrderStatus;
import com.project.course.repositories.CategoryRepository;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
/* A anotação "@Configuration" é usada para definir uma ou mais configurações de beans, métodos para criar e
 * configurar beans, ou importa outras classes de configuração. */
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    /* A anotação "@Autowired" é usada para realizar a injeção de dependência automaticamente em classes gerenciadas
     * pelo Spring, como componentes, serviços, repositórios, controladores, etc.
     * Quando usamos essa anotação o Spring procura automaticamente por uma instância correspondente do tipo do campo
     * ou parâmetro e a injeta nesse ponto de injeção. */
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    /* Quando a aplicação é iniciada, ela insere dois usuários no banco de dados usando o método "saveAll" do
     * "UserRepository". */
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        // Aqui estamos fazendo associações passando usuários no terceiro parâmetro:
        Order o1 = new Order(null, Instant.parse("2024-03-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2024-03-21T03:42:07Z"), u2, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.parse("2024-03-22T15:21:07Z"), u1, OrderStatus.WAITING_PAYMENT);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Beauty");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

    }

}