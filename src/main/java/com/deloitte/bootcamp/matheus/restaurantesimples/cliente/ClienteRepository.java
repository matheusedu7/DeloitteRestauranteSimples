package com.deloitte.bootcamp.matheus.restaurantesimples.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{

    Cliente findByEmail(String email);
}
