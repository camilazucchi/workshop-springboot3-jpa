package com.project.course.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    /* Cada constante acima possui um atributo "code", que é um número inteiro associado ao estado do pedido. */
    private final int code;

    /* O construtor é privado para garantir que os objetos OrderStatus só possam ser criados dentro do próprio enum.
     * Este construtor é usado para inicializar o atributo code de cada constante. */
    private OrderStatus(int code) {
        this.code = code;
    }

    /* Este método é utilizado para obter o código associado a um estado específico do pedido. */
    public int getCode() {
        return code;
    }

    /* Este método estático é utilizado para obter o estado do pedido correspondente a um determinado código. Ele itera
     * sobre todas as constantes enum e verifica se o código fornecido corresponde ao código de alguma constante.
     * Se correspondente, ele retorna a constante enum correspondente. Caso contrário, lança uma exceção. */
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Order Status code");
    }

}
