package com.ajel.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, BigDecimal>{	
		
	

}
