package com.example.gestao_usuarios.model;

import jakarta.persistence.Entity;  // Alterado para usar jakarta.persistence

@Entity
public class Usuario extends Pessoa {

    private String email;
    private String senha;

    public Usuario() {}

    public Usuario(String nome, String endereco, String email, String senha) {
        super(); 
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
