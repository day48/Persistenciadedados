package com.example.gestao_usuarios.controller;


import com.example.gestao_usuarios.model.Pessoa;
import com.example.gestao_usuarios.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public void salvar(@RequestBody Pessoa pessoa) {
        pessoaRepository.salvar(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return pessoaRepository.buscarPorId(id);
    }

    @PutMapping
    public void atualizar(@RequestBody Pessoa pessoa) {
        pessoaRepository.atualizar(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.buscarPorId(id);
        pessoaRepository.deletar(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.listar();
    }
}

