package com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Integer> {

}
