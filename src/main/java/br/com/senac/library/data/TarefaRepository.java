package br.com.senac.library.data;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.senac.library.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}


