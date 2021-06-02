package com.ajel.repository.filter;

import java.util.List;

public class ProdutoFilter {
	
	private Long codprod;
	private String descricao;
	private List<Long> marcas;

    public Long getCodprod() {
        return codprod;
    }

    public void setCodprod(Long codprod) {
        this.codprod = codprod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Long> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Long> marcas) {
        this.marcas = marcas;
    }
	
}
