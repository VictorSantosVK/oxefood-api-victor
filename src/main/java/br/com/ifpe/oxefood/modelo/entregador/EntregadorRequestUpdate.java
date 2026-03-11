package br.com.ifpe.oxefood.modelo.entregador;

import lombok.Data;

@Data
public class EntregadorRequestUpdate {
    private String nome;
    private String cpf;
    private String rg;
    private String foneCelular;
    private String placaVeiculo;
}