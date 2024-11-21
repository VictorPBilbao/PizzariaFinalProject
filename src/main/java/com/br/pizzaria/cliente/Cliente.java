package com.br.pizzaria.cliente;

public class Cliente {
    private String nome;
    private String sobrenome;
    private String telefone;
    private String CEP;
    private String numeroDaCasa;

    public Cliente(String nome, String sobrenome, String telefone, String CEP, String numeroDaCasa) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.CEP = CEP;
        this.numeroDaCasa = numeroDaCasa;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCEP() {
        return CEP;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", CEP='" + CEP + '\'' +
                ", numeroDaCasa='" + numeroDaCasa + '\'' +
                '}';
    }
}
