package com.ajel.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.TabPedido;


public interface PainelAcompanhaPedidoRepository extends JpaRepository<TabPedido, BigDecimal>{	
		
	

}
