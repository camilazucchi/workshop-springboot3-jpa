package com.project.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    /* Ao invés de utilizarmos List aqui, utilizamos Set, pois Set não permite elementos duplicados. Desta forma, não
     * corremos o risco de termos um produto com categorias duplicadas.
     * Além disso, instanciamos a coleção para que ela não comece com valor "null" e sim vazia. */
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    /* Esse trecho de código está definindo um relacionamento muitos-para-muitos entre produtos e categorias,
     * utilizando uma tabela de junção para representar esse relacionamento no banco de dados.
     * - "@ManyToMany": indica que há um relacionamento muitos-para-muitos entre as entidades "Product" e "Category".
     * Isso significa que um produto pode pertencer a várias categorias e uma categoria pode ter vários produtos.
     * - "@JoinTable": é usada para especificar os detalhes da tabela de junção que será criada para representar o
     * relacionamento muitos-para-muitos no banco de dados. A tabela de junção acima é chamada de "tb_product_category".
     * - "joinColumns" e "inverseJoinColumns": esses parâmetros especificam os nomes das colunas que serão usadas para
     * mapear o relacionamento. "joinColumns" se refere à coluna que irá conter as chaves estrangeiras da entidade
     * atual ("Product"), enquanto "inverseJoinColumns" se refere à coluna que irá conter as chaves estrangeiras da
     * outra entidade ("Category"). */
    private final Set<Category> categories = new HashSet<>();

    public Product() {
    }

    /* Observação: colocamos todos os atributos menos a coleção "categories" dentro do construtor, pois já instanciamos
     * a coleção anteriormente no atributo. */
    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
