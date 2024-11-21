package com.example.gestao_usuarios.controller;

import com.example.gestao_usuarios.model.Empresa;
import com.example.gestao_usuarios.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // Endpoint para salvar uma nova empresa ou atualizar uma existente
    @PostMapping
    public Empresa salvar(@RequestBody Empresa empresa) {
        return empresaService.salvar(empresa);  // Usa o método do service para salvar
    }

    // Endpoint para buscar uma empresa por ID
    @GetMapping("/{id}")
    public Optional<Empresa> buscarPorId(@PathVariable Long id) {
        return empresaService.buscarPorId(id);  // Usa o método do service para buscar
    }

    // Endpoint para atualizar uma empresa
    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        empresa.setId(id);  // Garantir que o ID da empresa seja passado corretamente
        return empresaService.salvar(empresa);  // Usa o método do service para atualizar
    }

    // Endpoint para deletar uma empresa por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        empresaService.deletar(id);  // Usa o método do service para deletar
    }

    // Endpoint para listar todas as empresas
    @GetMapping
    public List<Empresa> listar() {
        return empresaService.listar();  // Usa o método do service para listar
    }
}
