package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.TabPedido;
import com.example.repository.tabpedido.TabPedidoRepositoryQuery;

public interface TabPedidoRepository extends JpaRepository<TabPedido, Long>, TabPedidoRepositoryQuery{	
	

}
