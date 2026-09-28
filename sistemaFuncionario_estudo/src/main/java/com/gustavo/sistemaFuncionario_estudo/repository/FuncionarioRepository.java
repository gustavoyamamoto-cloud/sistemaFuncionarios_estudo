package com.gustavo.sistemaFuncionario_estudo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.sistemaFuncionario_estudo.entity.Funcionario;

@Repository 
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
    List<Funcionario> findByEmail(String email);

    List<Funcionario> findBySalarioGreaterThan(double salario);
}
