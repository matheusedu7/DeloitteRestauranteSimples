package com.deloitte.bootcamp.matheus.restaurantesimples.itemPedido;


import com.deloitte.bootcamp.matheus.restaurantesimples.pedido.Pedido;
import com.deloitte.bootcamp.matheus.restaurantesimples.produto.Produto;
import jakarta.persistence.*;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Produto produto;

    private Integer quantidade;

    private Double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
