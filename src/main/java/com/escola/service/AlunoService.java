package com.escola.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escola.model.Aluno;
import com.escola.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> getAluno(){
		return alunoRepository.findAll();
	}
	
	public void salvar(Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	public Aluno getAlunoById(Integer matricula) {
		return alunoRepository.findById(matricula).get();
	}// pesquisar aluno por id
	
	public void remover(Aluno aluno) {
		alunoRepository.delete(aluno);
	} // remover o aluno

}
