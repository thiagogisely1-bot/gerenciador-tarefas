package backend.service;

import backend.model.Tarefa;
import backend.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa nao encontrada"));
    }

    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }

    public void alternarStatus(Long id) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setConcluida(!tarefa.isConcluida());
        tarefaRepository.save(tarefa);
    }
}
