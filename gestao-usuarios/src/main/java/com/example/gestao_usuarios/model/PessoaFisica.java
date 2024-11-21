package com.example.gestao_usuarios.model;

import jakarta.persistence.*;  // Corrigido para jakarta.persistence
import java.time.LocalDate;
import java.util.List;

@Entity
public class PessoaFisica extends Usuario {

    private String cpf;
    private LocalDate dataNascimento;

    @ManyToMany
    @JoinTable(
      name = "pessoa_fisica_empresa", 
      joinColumns = @JoinColumn(name = "pessoa_fisica_id"), 
      inverseJoinColumns = @JoinColumn(name = "empresa_id"))
    private List<Empresa> empresas;

    public PessoaFisica() {}

    public PessoaFisica(String nome, String endereco, String email, String senha, String cpf, LocalDate dataNascimento) {
        super(nome, endereco, email, senha); // Chama o construtor da classe mãe
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}
