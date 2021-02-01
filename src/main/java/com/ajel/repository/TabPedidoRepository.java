package com.ajel.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.TabPedido;
import com.ajel.repository.tabpedido.TabPedidoRepositoryQuery;

public interface TabPedidoRepository extends JpaRepository<TabPedido, BigDecimal>, TabPedidoRepositoryQuery{	
		
	

}
