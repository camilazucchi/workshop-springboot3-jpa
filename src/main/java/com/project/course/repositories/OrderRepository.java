package com.project.course.repositories;

import com.project.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/* Esta interface estende "JpaRepository" e é responsável por fornecer métodos para realizar operações de CRUD na
* entidade "User" do banco de dados. */
public interface OrderRepository extends JpaRepository<Order, Long> {
}