package com.gustavo.sistemaFuncionario_estudo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.sistemaFuncionario_estudo.entity.Funcionario;

@Repository 
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
    List<Funcionario> findByEmail(String email);

    List<Funcionario> findBySalarioGreaterThan(double salario);
    List<Funcionario> findByIdadeLessThan(int idade);
    List<Funcionario> findBySalarioBetween(double min, double max);

    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    List<Funcionario> findByNomeOrEmail(String nome, String email);
    List<Funcionario> findByNomeAndIdade(String nome, int idade);
}
