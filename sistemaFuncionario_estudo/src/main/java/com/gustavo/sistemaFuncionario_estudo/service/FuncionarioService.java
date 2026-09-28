package com.gustavo.sistemaFuncionario_estudo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.sistemaFuncionario_estudo.dto.FuncionarioRequest;
import com.gustavo.sistemaFuncionario_estudo.dto.FuncionarioResponse;
import com.gustavo.sistemaFuncionario_estudo.entity.Funcionario;
import com.gustavo.sistemaFuncionario_estudo.repository.FuncionarioRepository;
import com.gustavo.sistemaFuncionario_estudo.validation.RecursoNaoEncontradoException;

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

    //Buscar
    public FuncionarioResponse buscarId(Long id){

        Funcionario f = repository.findById(id)
                                    .orElseThrow(() -> new RecursoNaoEncontradoException("Id não encontrado"));

        return new FuncionarioResponse(
                        f.getId(),
                        f.getNome(),
                        f.getEmail(),
                        f.getSalario(),
                        f.getIdade());
    }

    //Atualizar
    public FuncionarioResponse atualizar(Long id, FuncionarioRequest funcionarioNovo){

        Funcionario f = repository.findById(id)
                                    .orElseThrow(() -> new RecursoNaoEncontradoException("Id não encontrado"));

        f.setNome(funcionarioNovo.getNome());
        f.setEmail(funcionarioNovo.getEmail());
        f.setSalario(funcionarioNovo.getSalario());
        f.setIdade(funcionarioNovo.getIdade());

        repository.save(f);

        return new FuncionarioResponse(
                        f.getId(),
                        f.getNome(),
                        f.getEmail(),
                        f.getSalario(),
                        f.getIdade());
    }

    //Deletar
    public void deletar(Long id){

        buscarId(id);
        repository.deleteById(id);
    }

    //Buscar por email
    public List<FuncionarioResponse> buscarPorEmail(String email){
        
        List<Funcionario> funcionario = repository.findByEmail(email);

        return funcionario.stream()
                            .map(f -> new FuncionarioResponse(
                                            f.getId(),
                                            f.getNome(),
                                            f.getEmail(),
                                            f.getSalario(),
                                            f.getIdade()))
                            .toList();
    }

    //Buscar salarios Maior que ...
    public List<FuncionarioResponse> buscarSalarioMaiorQue(double salario){

        List<Funcionario> funcionario = repository.findBySalarioGreaterThan(salario);

        return funcionario.stream()
                            .map(f -> new FuncionarioResponse(
                                            f.getId(),
                                            f.getNome(),
                                            f.getEmail(),
                                            f.getSalario(),
                                            f.getIdade()))
                            .toList();
    }

    //Buscar idade menor que ...
    public List<FuncionarioResponse> buscarIdadeMenorQue(int idade){

        List<Funcionario> funcionario = repository.findByIdadeLessThan(idade);

        return funcionario.stream()
                            .map(f -> new FuncionarioResponse(
                                            f.getId(),
                                            f.getNome(),
                                            f.getEmail(),
                                            f.getSalario(),
                                            f.getIdade()))
                            .toList();
    }

    //Buscar salario entre valores
    public List<FuncionarioResponse> buscarSalarioEntreValores(double min, double max){

        List<Funcionario> funcionario = repository.findBySalarioBetween(min, max);

        return funcionario.stream()
                            .map(f -> new FuncionarioResponse(
                                            f.getId(),
                                            f.getNome(),
                                            f.getEmail(),
                                            f.getSalario(),
                                            f.getIdade()))
                            .toList();
    }

    //Buscar nome ignorando maiusculos e minusculas
    public List<FuncionarioResponse> buscarPorNome(String nome){

        List<Funcionario> funcionario = repository.findByNomeContainingIgnoreCase(nome);

        return funcionario.stream()
                            .map(f -> new FuncionarioResponse(
                                            f.getId(),
                                            f.getNome(),
                                            f.getEmail(),
                                            f.getSalario(),
                                            f.getIdade()))
                            .toList();
    }
}
