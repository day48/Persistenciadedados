package com.example.gestao_usuarios.model;

import jakarta.persistence.*;  
import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "empresas")
    private List<PessoaFisica> pessoaFisicas;

    @OneToMany(mappedBy = "empresa")
    private List<PessoaJuridica> pessoaJuridicas;

    // Construtores
    public Empresa() {}

    public Empresa(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(List<PessoaFisica> pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public List<PessoaJuridica> getPessoaJuridicas() {
        return pessoaJuridicas;
    }

    public void setPessoaJuridicas(List<PessoaJuridica> pessoaJuridicas) {
        this.pessoaJuridicas = pessoaJuridicas;
    }
}
