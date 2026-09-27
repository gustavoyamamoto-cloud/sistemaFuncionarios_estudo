package com.gustavo.sistemaFuncionario_estudo.service;

import org.springframework.stereotype.Service;

import com.gustavo.sistemaFuncionario_estudo.repository.FuncionarioRepository;

@Service 
public class FuncionarioService {
    
    public final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    
}
