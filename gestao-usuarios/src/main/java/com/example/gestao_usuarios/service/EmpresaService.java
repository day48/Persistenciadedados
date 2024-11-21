package com.example.gestao_usuarios.service;

import com.example.gestao_usuarios.model.Empresa;
import com.example.gestao_usuarios.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Salvar ou atualizar uma empresa (save() já faz isso)
    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // Buscar uma empresa por ID
    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepository.findById(id);  // findById retorna Optional
    }

    // Deletar uma empresa
    public void deletar(Long id) {
        empresaRepository.deleteById(id);  // Deleta a empresa pelo ID
    }

    // Listar todas as empresas
    public List<Empresa> listar() {
        return empresaRepository.findAll();  // findAll lista todas as empresas
    }
}
