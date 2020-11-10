package com.example.repository.tabpedido;

import java.util.List;

import com.example.model.TabPedido;
import com.example.repository.filter.TabPedidosFilter;

public interface TabPedidoRepositoryQuery {
	
	public List<TabPedido> filtrar( TabPedidosFilter tabPedidosFilter);

}
