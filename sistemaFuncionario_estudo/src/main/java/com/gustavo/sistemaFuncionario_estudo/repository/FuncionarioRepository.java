package com.gustavo.sistemaFuncionario_estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.sistemaFuncionario_estudo.entity.Funcionario;

@Repository 
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    

}
