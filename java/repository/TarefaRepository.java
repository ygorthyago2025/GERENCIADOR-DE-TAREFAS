package repository;

import java.util.ArrayList;
import java.util.List;
import model.Tarefa;

public class TarefaRepository {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void salvar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public List<Tarefa> listar() {
        return tarefas;
    }

    public Tarefa buscarPorId(int id) {
        return tarefas.stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public boolean remover(int id) {
        return tarefas.removeIf(t -> t.getId() == id);
    }
}
