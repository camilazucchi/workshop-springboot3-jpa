package com.project.course.repositories;

import com.project.course.entities.Category;
import com.project.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/* Esta interface estende "JpaRepository" e é responsável por fornecer métodos para realizar operações de CRUD na
* entidade "User" do banco de dados. */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}