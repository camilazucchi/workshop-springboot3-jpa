package com.project.course.config;

import com.project.course.entities.Category;
import com.project.course.entities.Order;
import com.project.course.entities.Product;
import com.project.course.entities.User;
import com.project.course.enums.OrderStatus;
import com.project.course.repositories.CategoryRepository;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.ProductRepository;
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
    private final ProductRepository productRepository;

    @Autowired
    /* A anotação "@Autowired" é usada para realizar a injeção de dependência automaticamente em classes gerenciadas
     * pelo Spring, como componentes, serviços, repositórios, controladores, etc.
     * Quando usamos essa anotação o Spring procura automaticamente por uma instância correspondente do tipo do campo
     * ou parâmetro e a injeta nesse ponto de injeção. */
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository,
                      CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
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

        Product p1 = new Product(null, "The Lord of the Rings",
                "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV",
                "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro",
                "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer",
                "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies",
                "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        // Salvando no banco de dados:
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }

}