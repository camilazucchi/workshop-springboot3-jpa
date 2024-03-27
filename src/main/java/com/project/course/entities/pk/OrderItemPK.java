package com.project.course.entities.pk;

import com.project.course.entities.Order;
import com.project.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

/* Uma classe auxiliar de chave primária composta é frequentemente usada em sistemas de banco de dados relacionais
 * para representar tabelas que possuem chaves primárias compostas, ou seja, chaves primárias que consistem em mais de
 * um campo. Em Java, para mapear essa estrutura de banco de dados para objetos, é comum utilizar uma classe auxiliar
 * para representar a chave primária composta. */
@Embeddable
/* A anotação "@Embeddable" é usada para representar tipos de dados complexos que podem ser incorporados em outras
 * entidades persistentes. Cria uma relação de composição entre entidades. */
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    /* As anotações @JoinColumn são usadas para especificar os nomes das colunas nas tabelas do banco de dados que
     * armazenam as chaves estrangeiras referentes a "order" e "product". */
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        OrderItemPK that = (OrderItemPK) object;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

}
