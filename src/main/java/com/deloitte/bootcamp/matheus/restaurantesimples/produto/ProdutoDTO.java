package com.deloitte.bootcamp.matheus.restaurantesimples.produto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private Long id;

    private String nome;

    private Double preco;

}
