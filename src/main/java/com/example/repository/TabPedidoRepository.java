package com.example.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.TabPedido;
import com.example.repository.tabpedido.TabPedidoRepositoryQuery;

public interface TabPedidoRepository extends JpaRepository<TabPedido, BigDecimal>, TabPedidoRepositoryQuery{	
		
	

}
