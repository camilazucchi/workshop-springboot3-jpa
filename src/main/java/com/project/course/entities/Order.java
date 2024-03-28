package com.project.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.course.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* Antes da versão 8 do Java, para instanciar um instante usávamos a classe Date, mas a partir da versão 8, surgiu
     * a classe Instant, sendo melhor que Date no nosso caso.
     * https://stackoverflow.com/questions/32437550/whats-the-difference-between-instant-and-localdatetime */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'", timezone = "GMT")
    /* A anotação "@JsonFormat" é usada para definir o formato de serialização/desserialização de campos de data e hora
     * quando convertidos para JSON e vice-versa.
     * - Shape: especifica a forma como o valor do campo deve ser serializado.
     * - Pattern: define o padrão para formatar data e hora.
     * - Timezone: especifica o fuso horário que deve ser usado ao serializar/desserializar a data e hora. */
    private Instant moment;
    private Integer orderStatus;

    @ManyToOne
    /* A anotação "@ManyToOne" é usada para mapear um relacionamento muitos-para-um entre duas entidades em um banco
     * de dados relacional. */
    @JoinColumn(name = "client_id")
    /* A anotação "@JoinColumn" é usada em conjunto com outras anotações de relacionamento, como "@ManyToOne" e
     * "@OneToOne", para especificar a coluna na tabela do banco de dados que representa a chave estrangeira que
     * mantém o relacionamento entre as entidades. */
    private User client;
    @OneToMany(mappedBy = "id.order")
    private final Set<OrderItem> items = new HashSet<>();
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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
