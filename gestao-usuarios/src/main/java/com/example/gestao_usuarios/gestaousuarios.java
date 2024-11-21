package com.example.gestao_usuarios;

import com.example.gestao_usuarios.model.Empresa;
import com.example.gestao_usuarios.model.PessoaFisica;
import com.example.gestao_usuarios.model.PessoaJuridica;
import com.example.gestao_usuarios.repository.EmpresaRepository;
import com.example.gestao_usuarios.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class gestaousuarios {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    
    public void associarPessoaFisicaAEmpresa(Long pessoaFisicaId, Long empresaId) {
        
        Optional<PessoaFisica> pessoaFisicaOpt = Optional.empty();
        Optional<Empresa> empresaOpt = empresaRepository.findById(empresaId);

        if (pessoaFisicaOpt.isPresent() && empresaOpt.isPresent()) {
            PessoaFisica pessoaFisica = pessoaFisicaOpt.get();
            Empresa empresa = empresaOpt.get();
            pessoaFisica.getEmpresas().add(empresa);  
            pessoaRepository.salvar(pessoaFisica);  
        }
    }

    public void associarPessoaJuridicaAEmpresa(Long pessoaJuridicaId, Long empresaId) {
        
        Optional<PessoaJuridica> pessoaJuridicaOpt = pessoaRepository.findById(pessoaJuridicaId);
        Optional<Empresa> empresaOpt = empresaRepository.findById(empresaId);

        
        if (pessoaJuridicaOpt.isPresent() && empresaOpt.isPresent()) {
            PessoaJuridica pessoaJuridica = pessoaJuridicaOpt.get();
            Empresa empresa = empresaOpt.get();
            pessoaJuridica.setEmpresa(empresa);  
            pessoaRepository.salvar(pessoaJuridica);  
        }
    }
}
