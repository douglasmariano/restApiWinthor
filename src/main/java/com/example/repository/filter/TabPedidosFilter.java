package com.example.repository.filter;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class TabPedidosFilter {
	
	private BigDecimal numped;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataPedidoDe;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataPedidoAte;
	
	private String nomeCliente;
	
	private String nomeVendedor;
	
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public BigDecimal getNumped() {
		return numped;
	}
	public void setNumped(BigDecimal numped) {
		this.numped = numped;
	}
	public LocalDate getDataPedidoDe() {
		return dataPedidoDe;
	}
	public void setDataPedidoDe(LocalDate dataPedidoDe) {
		this.dataPedidoDe = dataPedidoDe;
	}
	public LocalDate getDataPedidoAte() {
		return dataPedidoAte;
	}
	public void setDataPedidoAte(LocalDate dataPedidoAte) {
		this.dataPedidoAte = dataPedidoAte;
	}
}
