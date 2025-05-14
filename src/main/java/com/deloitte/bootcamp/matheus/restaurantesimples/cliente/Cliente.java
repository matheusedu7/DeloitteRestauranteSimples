package com.deloitte.bootcamp.matheus.restaurantesimples.cliente;


import com.deloitte.bootcamp.matheus.restaurantesimples.pedido.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedido;


    // ============== GETTERS E SETTERS ==============
}
