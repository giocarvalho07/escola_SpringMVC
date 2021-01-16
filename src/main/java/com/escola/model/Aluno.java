package com.escola.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name="ID_CURSO")
    private Curso curso;
    // classe curso
    // junção de coluna ao invés de uma tabela auxiliar
    
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", curso=" + curso.getNome() + "]";
	//ajustar para mostrar nome do curso
	}

}
