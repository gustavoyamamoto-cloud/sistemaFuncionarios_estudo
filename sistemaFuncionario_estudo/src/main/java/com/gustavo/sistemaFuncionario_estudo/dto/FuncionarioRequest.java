package com.gustavo.sistemaFuncionario_estudo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class FuncionarioRequest {
    
    @NotBlank(message = "Nome obrigatorio")
    private String nome;

    @Email(message = "Email escrito de forma errada")
    private String email;

    @Positive(message = "Salario deve ser positivo") 
    private double salario;

    @Size(min = 18, max = 70, message = "Idade deve ser entre 18 a 70 anos")
    private int idade;


    public FuncionarioRequest() {}

    public FuncionarioRequest(String nome, String email, double salario, int idade) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
