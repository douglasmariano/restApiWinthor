package com.ajel.repository.filter;

import java.util.List;

public class ProdutoFilter {
	
	private Long codprod;
	private String descricao;
	private List<Long> codmarca;

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

    public List<Long> getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(List<Long> codmarca) {
        this.codmarca = codmarca;
    }
	
}
