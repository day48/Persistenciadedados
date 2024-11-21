package com.example.gestao_usuarios.service;


import com.example.gestao_usuarios.model.Pessoa;
import com.example.gestao_usuarios.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvar(Pessoa pessoa) {
        // Aqui você pode adicionar lógica adicional de validação ou manipulação de dados
        pessoaRepository.salvar(pessoa);
    }

    public void atualizar(Pessoa pessoa) {
        // Lógica de negócios, por exemplo, verificar se a pessoa existe antes de atualizar
        pessoaRepository.atualizar(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.buscarPorId(id);
    }

    public void deletar(Long id) {
        Pessoa pessoa = pessoaRepository.buscarPorId(id);
        pessoaRepository.deletar(pessoa);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.listar();
    }
}

