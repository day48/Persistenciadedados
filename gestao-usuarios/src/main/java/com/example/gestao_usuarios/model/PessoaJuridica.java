package com.example.gestao_usuarios.model;

import jakarta.persistence.*;  // Corrigido para jakarta.persistence

@Entity
public class PessoaJuridica extends Usuario {

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;

    @ManyToOne
    private Empresa empresa;

    public PessoaJuridica() {}

    public PessoaJuridica(String nome, String endereco, String email, String senha, String cnpj, String razaoSocial, String nomeFantasia) {
        super(nome, endereco, email, senha);  // Chama o construtor da classe mãe
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
