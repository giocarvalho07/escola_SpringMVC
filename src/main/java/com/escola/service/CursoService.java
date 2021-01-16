package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Curso;
import com.escola.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> getCurso(){
		return cursoRepository.findAll();
	}
	
	public void salvar(Curso curso) {
		cursoRepository.save(curso); 
	}
	
	public Curso getCursoById(int id) {
		return cursoRepository.findById(id).get();
		// buscra por id e retornar
	}

}
