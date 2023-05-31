package br.com.senac.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.senac.library.data.TarefaRepository;
import br.com.senac.library.model.Tarefa;

@Controller
public class TarefaController {
    
    @Autowired
   TarefaRepository repository;

    //localhost/tarfear
    @GetMapping("/tarefas")
    public String tarefas(Model model){
        var tarefas = repository.findAll();
        model.addAttribute("tarefas", tarefas);
        return "tarefas";
    }

    @GetMapping("/tarefas/cadastrar")
    public String formulario(){
        return "formulario_tarefa";
    }

    
    @GetMapping("/")
    public String home(){
        return"redirect:/tarefas";
    }

    @DeleteMapping("/tarefas")
    public String apagar(Long id , RedirectAttributes redirect){
       repository.deleteById(id);
       redirect.addFlashAttribute("mensagem", "Tarefa apagada com sucesso");
       return"redirect:/tarefas";
    }

    @PostMapping("/tarefas")
    public String cadastrar(Tarefa tarefa){
        System.out.println(tarefa);
        repository.save(tarefa);
        return"redirect:/tarefas";       
    }
  
}