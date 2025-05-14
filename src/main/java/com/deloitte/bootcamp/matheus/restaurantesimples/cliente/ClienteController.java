package com.deloitte.bootcamp.matheus.restaurantesimples.cliente;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodosClientes() {
        List<ClienteDTO> clientes = ClienteService.buscarTodosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);



    }

}
