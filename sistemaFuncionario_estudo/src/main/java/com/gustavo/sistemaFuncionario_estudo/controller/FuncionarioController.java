package com.gustavo.sistemaFuncionario_estudo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.sistemaFuncionario_estudo.dto.FuncionarioRequest;
import com.gustavo.sistemaFuncionario_estudo.dto.FuncionarioResponse;
import com.gustavo.sistemaFuncionario_estudo.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    public final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    
    @GetMapping 
    public List<FuncionarioResponse> listar(){
        return service.listar();
    }

    @PostMapping 
    public FuncionarioResponse cadastrar(@Valid @RequestBody FuncionarioRequest funcionario){
        return service.cadastrar(funcionario);
    }

    @GetMapping("/{id}")
    public FuncionarioResponse buscar(@PathVariable Long id){
        return service.buscarId(id);
    }

    @PutMapping("/{id}")
    public FuncionarioResponse atualizar(@PathVariable Long id, @Valid @RequestBody FuncionarioRequest funcionario){
        return service.atualizar(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }



    @GetMapping("/email/{email}")
    public List<FuncionarioResponse> buscarPorEmail(@PathVariable String email){
        return service.buscarPorEmail(email);
    }



    @GetMapping("/salario-maiorQue/{salario}")
    public List<FuncionarioResponse> buscarSalarioMaiorQue(@PathVariable double salario){
        return service.buscarSalarioMaiorQue(salario);
    }

    @GetMapping("/idade-menorQue/{idade}")
    public List<FuncionarioResponse> buscarIdadeMenorQue(@PathVariable int idade){
        return service.buscarIdadeMenorQue(idade);
    }

    @GetMapping("/salario-entre/{min}/{max}")
    public List<FuncionarioResponse> buscarSalarioEntreValores(@PathVariable double min, @PathVariable double max){
        return service.buscarSalarioEntreValores(min, max);
    }


    @GetMapping("/nome/{nome}")
    public List<FuncionarioResponse> buscarPorNome(@PathVariable String nome){
        return service.buscarPorNome(nome);
    }


    @GetMapping("/nomeOuEmail/{nome}/{email}")
    public List<FuncionarioResponse> buscarNomeOrEmail(@PathVariable String nome, @PathVariable String email){
        return service.buscarNomeOrEmail(nome, email);
    }

    @GetMapping("/nomeAndIdade/{nome}/{idade}")
    public List<FuncionarioResponse> buscarNomeAndIdade(@PathVariable String nome, @PathVariable int idade){
        return service.buscarNomeAndIdade(nome, idade);
    }
}
