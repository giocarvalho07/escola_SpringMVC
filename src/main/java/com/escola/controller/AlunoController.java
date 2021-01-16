package com.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.escola.model.Aluno;
import com.escola.service.AlunoService;
import com.escola.service.CursoService;


@Controller
public class AlunoController {
	
    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private CursoService cursoService;
    
    // adicionar autowired do service em curso e alunos
    
    @GetMapping("/alunos")
    public ModelAndView getAlunos(){
        ModelAndView model = new ModelAndView("alunoTemplate");
        
        model.addObject("aluno", new Aluno());
        model.addObject("alunos", alunoService.getAluno());
        model.addObject("cursos", cursoService.getCurso());
        
        // instanciar um objeto aluno
        // e pear o modelAddObject em aluno e curso
        return model;
    }
    
    
    /*
    Salvar ou atualiza um objeto.
    Se a matricula for igual a zerp, cria um novo aluno
    Se a matricula for diferente de zero e existir na tabela aluno, atualiza o aluno.
*/

    @PostMapping("/salvar-alunos")
    public String salvar(@ModelAttribute Aluno aluno){
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }
    
    
    @GetMapping("/removerAluno") // recebe como parametro uma mátricula
    public String removerAluno(@RequestParam Integer matricula){
        // busca uma matricula no banco, se tiver ele apaga
        Aluno aluno = alunoService.getAlunoById(matricula);
        alunoService.remover(aluno);
        return "redirect:/alunos";
    }
    
    @GetMapping("/editarAluno")
    public ModelAndView editarAluno(@RequestParam Integer matricula){
        
        ModelAndView model = new ModelAndView("alunoEdit");
    
        Aluno aluno = alunoService.getAlunoById(matricula); 
        model.addObject("aluno",  aluno);
        model.addObject("cursos", cursoService.getCurso());

        return model;
   
    }
}
