package com.ajel.repository.tabpedido;

import java.util.List;

import com.ajel.model.TabPedido;
import com.ajel.repository.filter.TabPedidosFilter;

public interface TabPedidoRepositoryQuery {
	
	public List<TabPedido> filtrar( TabPedidosFilter tabPedidosFilter);

}
