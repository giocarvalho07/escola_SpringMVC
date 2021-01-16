package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Professor;
import com.escola.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
    @Autowired
    private ProfessorRepository professorRepository;
    
    public void salvar(Professor professor) {
    	professorRepository.save(professor);
    }

    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    public Professor getProfessorById(int codigo) {
        return professorRepository.findById(codigo).get();
    }

}
