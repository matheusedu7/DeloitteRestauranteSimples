package com.deloitte.bootcamp.matheus.restaurantesimples.pedido;

import com.deloitte.bootcamp.matheus.restaurantesimples.itemPedido.ItemPedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long clienteId;
    private List<ItemPedidoDTO> itens;
    private Double total;
    private LocalDateTime dataPedido;

}
