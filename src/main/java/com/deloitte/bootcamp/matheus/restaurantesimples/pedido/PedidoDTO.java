package com.deloitte.bootcamp.matheus.restaurantesimples.pedido;

import com.deloitte.bootcamp.matheus.restaurantesimples.itemPedido.ItemPedido;

import java.util.List;

public class PedidoDTO {
    private Long clienteId;

    private List<ItemPedido> itens;
}
