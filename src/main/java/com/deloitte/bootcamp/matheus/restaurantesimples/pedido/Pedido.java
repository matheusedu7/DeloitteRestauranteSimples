package com.deloitte.bootcamp.matheus.restaurantesimples.pedido;


import com.deloitte.bootcamp.matheus.restaurantesimples.cliente.Cliente;
import com.deloitte.bootcamp.matheus.restaurantesimples.itemPedido.ItemPedido;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    private Long id;

    private Double total;

    private LocalDateTime dataPedido = LocalDateTime.now();

    private Cliente cliente;

    private List<ItemPedido> itens = new ArrayList<>();
}
