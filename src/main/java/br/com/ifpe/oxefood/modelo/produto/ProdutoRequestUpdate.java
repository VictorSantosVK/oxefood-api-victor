package br.com.ifpe.oxefood.modelo.produto;

import lombok.Data;

@Data
public class ProdutoRequestUpdate {

    private String nome;
    private String descricao;
    private Double valor;
}