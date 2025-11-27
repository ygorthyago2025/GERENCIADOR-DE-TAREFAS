package service;

import model.Tarefa;
import repository.TarefaRepository;

import java.time.LocalDate;
import java.util.List;

public class TarefaService {

    private TarefaRepository repository = new TarefaRepository();

    public void criarTarefa(String titulo, String descricao, LocalDate data) {
        Tarefa t = new Tarefa(titulo, descricao, data);
        repository.salvar(t);
    }

    public List<Tarefa> listarTarefas() {
        return repository.listar();
    }

    public boolean atualizarTarefa(int id, String novoTitulo, String novaDescricao, LocalDate novaData) {
        Tarefa t = repository.buscarPorId(id);
        if (t == null) return false;

        t.setTitulo(novoTitulo);
        t.setDescricao(novaDescricao);
        t.setDataConclusao(novaData);
        return true;
    }

    public boolean excluirTarefa(int id) {
        return repository.remover(id);
    }
}
