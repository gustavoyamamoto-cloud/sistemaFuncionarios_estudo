package com.gustavo.sistemaFuncionario_estudo.dto;

public class FuncionarioResponse {
    
    private Long id;
    private String nome;
    private String email;
    private double salario;
    private int idade;


    public FuncionarioResponse(Long id, String nome, String email, double salario, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.idade = idade;
    }

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
