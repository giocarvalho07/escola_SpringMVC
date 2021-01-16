package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.escola.model.Curso;
import com.escola.model.Professor;
import com.escola.service.CursoService;
import com.escola.service.ProfessorService;


@Controller
public class ProfessorController {
	
	@Autowired
    private ProfessorService professorService;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/professores")
    public ModelAndView getProfessores() {
        ModelAndView model = new ModelAndView("professorTemplate");
        model.addObject("professores", professorService.getProfessores());
        return model;
    }

    @PostMapping("/salvar-professor")
    public String salvar(@ModelAttribute Professor professor) {
        professorService.salvar(professor);
        return "redirect:/professores";
    }

    @PostMapping("/associarCursoProfessor") // via consulta - query
    public String associarCurso(@ModelAttribute Curso curso, @RequestParam Integer codigoProfessor) { // recuperar objeto curso, e pegar id do professor via parametro na url
        Professor professor = professorService.getProfessorById(codigoProfessor); // com o id vou no banco e recupero o objeto professor
        curso = cursoService.getCursoById(curso.getId()); // recupero o id do curso
        professor.getCursos().add(curso); // uma lista de curso dos professores, adicionando
        professorService.salvar(professor); // estamos atualizando os dados do professores
        return "redirect:/professorDetalhe/" + codigoProfessor;  // redirect variável
    }

    @GetMapping("/professorDetalhe/{codigo}")
    public ModelAndView getCursoDetalhes(@PathVariable(name = "codigo") Integer codigo) {
        Professor professor = professorService.getProfessorById(codigo);
        ModelAndView model = new ModelAndView("professorDetalhe");
        model.addObject("professor", professor);
        List <Curso> cursosNaoAssociados = cursoService.getCurso();
        cursosNaoAssociados.removeAll(professor.getCursos());
        model.addObject("cursos", cursosNaoAssociados);
        return model;
    }

}
