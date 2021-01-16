package com.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.escola.model.Curso;
import com.escola.service.CursoService;

@Controller
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/cursos")
	public ModelAndView getCurso() {
		ModelAndView model = new ModelAndView("cursoTemplate");
		model.addObject("cursos", cursoService.getCurso());
		return model;
	}
	
	@PostMapping("/salvar-cursos")
	public String salvar(@ModelAttribute Curso curso) {
		cursoService.salvar(curso);
		return "redirect:/cursos";
	}
	
	@GetMapping("/curso-detalhe/{id}")
	public ModelAndView getCursoDetalhe(@PathVariable(name="id") Integer id) {
		Curso curso = cursoService.getCursoById(id);
		ModelAndView model = new ModelAndView("cursoDetalhe");
		model.addObject("curso", curso);
		return model;
	}
	
	// método para exibir pagina de detalhes, com o id correto
	// buscado pelo id

}
