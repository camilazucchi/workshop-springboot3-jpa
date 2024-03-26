package com.project.course.services;

import com.project.course.entities.Order;
import com.project.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /* Este método retorna uma lista de todos os usuários presentes no banco de dados. Ele faz isso chamando o método
     * "findAll()" do "OrderRepository", que é uma interface fornecida pelo Spring Data JPA. */
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    /* O tipo "Optional" foi introduzido no Java para lidar de forma mais segura e expressiva com valores que podem
     * estar ausentes. Ele permite indicar explicitamente que um valor pode estar presente ou ausente, evitando assim
     * exceções de "NullPointerException". */
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

}
