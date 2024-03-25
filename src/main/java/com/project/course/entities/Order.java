package com.project.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* Antes da versão 8 do Java, para instanciar um instante usávamos a classe Date, mas a partir da versão 8, surgiu
     * a classe Instant, sendo melhor que Date no nosso caso.
     * https://stackoverflow.com/questions/32437550/whats-the-difference-between-instant-and-localdatetime */
    private Instant instant;

    @ManyToOne
    /* A anotação "@ManyToOne" é usada para mapear um relacionamento muitos-para-um entre duas entidades em um banco
     * de dados relacional. */
    @JoinColumn(name = "client_id")
    /* A anotação "@JoinColumn" é usada em conjunto com outras anotações de relacionamento, como "@ManyToOne" e
     * "@OneToOne", para especificar a coluna na tabela do banco de dados que representa a chave estrangeira que
     * mantém o relacionamento entre as entidades. */
    private User client;

    public Order() {
    }

    public Order(Long id, Instant instant, User client) {
        this.id = id;
        this.instant = instant;
        this.client = client;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Order order = (Order) object;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
