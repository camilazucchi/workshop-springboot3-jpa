package com.project.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.course.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_ordem_item")
public class OrderItem implements Serializable {

    @EmbeddedId
    /* A anotação "@EmbeddedId" é usada para indicar que uma entidade possui uma chave primária composta e que esta
     * chave primária composta é incorporada diretamente na própria entidade como um objeto embutido. */
    private OrderItemPK id;
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    /* Houve um problema nesse construtor. Antes, não estávamos inicializando o objeto da chave primária composta
     * "OrderItemPK". Quando criamos um novo objeto "OrderItem", também precisamos criar um novo objeto "OrderItemPK"
     * e definir os valores "order" e "product" nele. */
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id = new OrderItemPK();
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        OrderItem orderItem = (OrderItem) object;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
