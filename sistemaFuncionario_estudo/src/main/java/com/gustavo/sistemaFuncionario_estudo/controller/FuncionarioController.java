package com.gustavo.sistemaFuncionario_estudo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.sistemaFuncionario_estudo.service.FuncionarioService;

@RestController 
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    public final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    
}
