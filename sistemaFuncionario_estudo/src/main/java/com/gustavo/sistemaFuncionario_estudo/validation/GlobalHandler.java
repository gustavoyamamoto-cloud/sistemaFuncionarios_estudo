package com.gustavo.sistemaFuncionario_estudo.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarExcecaoPerconalizada(RecursoNaoEncontradoException ex){

        ErroResponse resposta = new ErroResponse(
                                    404,
                                    "Recurso",
                                    ex.getMessage());

        return ResponseEntity
                    .status(404)
                    .body(resposta);
    }
}
