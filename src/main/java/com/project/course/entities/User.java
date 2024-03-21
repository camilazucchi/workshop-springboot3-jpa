package com.project.course.entities;

import java.io.Serializable;
import java.util.Objects;

/* Quando uma classe implementa a interface "Serializable" em Java, isso significa que os objetos dessa classe podem
 * ser convertidos em uma sequência de bytes. Essa sequência de bytes pode ser posteriormente gravada em um arquivo,
 * transmitida pela rede ou armazenada na memória de forma persistente. */
public class User implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* Esses métodos são comumente usados em Java para implementar a comparação de igualdade e gerar um código hash
     * para objetos de uma classe.
     * O método "equals" verifica se o objeto atual é igual a outro objeto.
     * O método "hashCode" gera um código hash para o objeto. O código hash é um número inteiro usado em algoritmos de
     * estruturas de dados, como tabelas de hash, para indexar objetos. */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}