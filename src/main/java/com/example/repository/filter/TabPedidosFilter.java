package com.example.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class TabPedidosFilter {
	
	private String Numped;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataPedidoDe;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataPedidoAte;
	
	
	public String getNumped() {
		return Numped;
	}
	public void setNumped(String numped) {
		Numped = numped;
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
