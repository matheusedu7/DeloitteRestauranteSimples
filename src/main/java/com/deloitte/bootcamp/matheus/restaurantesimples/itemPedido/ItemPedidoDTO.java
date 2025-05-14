package com.deloitte.bootcamp.matheus.restaurantesimples.itemPedido;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private Long produtoId;

    private Integer quantidade;
}
