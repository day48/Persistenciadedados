package com.example.gestao_usuarios.repository;

import com.example.gestao_usuarios.model.Pessoa;
import com.example.gestao_usuarios.model.PessoaJuridica;

import jakarta.persistence.EntityManager;  
import jakarta.persistence.TypedQuery;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepository {

    @Autowired
    private EntityManager entityManager;

    public void salvar(Pessoa pessoa) {
        if (pessoa.getId() == null) {
            entityManager.persist(pessoa);
        } else {
            entityManager.merge(pessoa);
        }
    }

    public void atualizar(Pessoa pessoa) {
        entityManager.merge(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public void deletar(Pessoa pessoa) {
        if (entityManager.contains(pessoa)) {
            entityManager.remove(pessoa);
        } else {
            entityManager.remove(entityManager.merge(pessoa));
        }
    }

    public List<Pessoa> listar() {
        String jpql = "SELECT p FROM Pessoa p";
        TypedQuery<Pessoa> query = entityManager.createQuery(jpql, Pessoa.class);
        return query.getResultList();
    }

    public Optional<PessoaJuridica> findById(Long pessoaJuridicaId) {
       
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
