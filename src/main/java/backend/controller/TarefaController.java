package backend.controller;

import backend.model.Tarefa;
import backend.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tarefas", tarefaService.listarTodas());
        return "tarefas/lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "tarefas/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Tarefa tarefa, BindingResult result) {
        if (result.hasErrors()) {
            return "tarefas/form";
        }

        tarefaService.salvar(tarefa);
        return "redirect:/tarefas";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("tarefa", tarefaService.buscarPorId(id));
        return "tarefas/form";
    }

    @PostMapping("/{id}/status")
    public String alternarStatus(@PathVariable Long id) {
        tarefaService.alternarStatus(id);
        return "redirect:/tarefas";
    }

    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
        return "redirect:/tarefas";
    }
}
