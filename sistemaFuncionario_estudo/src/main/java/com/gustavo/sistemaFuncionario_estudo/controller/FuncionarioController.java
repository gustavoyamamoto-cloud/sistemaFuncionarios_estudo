package com.gustavo.sistemaFuncionario_estudo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

    @PutMapping 
    public FuncionarioResponse cadastrar(@Valid @RequestBody FuncionarioRequest funcionario){
        return service.cadastrar(funcionario);
    }
}
