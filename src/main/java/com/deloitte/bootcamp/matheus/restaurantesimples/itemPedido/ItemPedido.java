package com.deloitte.bootcamp.matheus.restaurantesimples.itemPedido;


import com.deloitte.bootcamp.matheus.restaurantesimples.pedido.Pedido;
import com.deloitte.bootcamp.matheus.restaurantesimples.produto.Produto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


    private Integer quantidade;

    private BigDecimal precoUnitario;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    // ============ GETTERS E SETTERS ==============

}
