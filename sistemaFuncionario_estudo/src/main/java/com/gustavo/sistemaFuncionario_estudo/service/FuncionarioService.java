package com.gustavo.sistemaFuncionario_estudo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.sistemaFuncionario_estudo.dto.FuncionarioRequest;
import com.gustavo.sistemaFuncionario_estudo.dto.FuncionarioResponse;
import com.gustavo.sistemaFuncionario_estudo.entity.Funcionario;
import com.gustavo.sistemaFuncionario_estudo.repository.FuncionarioRepository;

@Service 
public class FuncionarioService {
    
    public final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    //Listar
    public List<FuncionarioResponse> listar(){

        return repository.findAll()
                            .stream()
                            .map(f -> new FuncionarioResponse(
                                                f.getId(),
                                                f.getNome(),
                                                f.getEmail(),
                                                f.getSalario(),
                                                f.getIdade()))
                            .toList();
    }

    //Cadastrar
    public FuncionarioResponse cadastrar(FuncionarioRequest funcionario){

        Funcionario f = new Funcionario();

        f.setNome(funcionario.getNome());
        f.setEmail(funcionario.getEmail());
        f.setSalario(funcionario.getSalario());
        f.setIdade(funcionario.getIdade());

        repository.save(f);

        return new FuncionarioResponse(
                        f.getId(),
                        f.getNome(),
                        f.getEmail(),
                        f.getSalario(),
                        f.getIdade());
    }
}
