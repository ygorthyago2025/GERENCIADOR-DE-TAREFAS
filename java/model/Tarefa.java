package model;

import java.time.LocalDate;

public class Tarefa {
    private static int contador = 1;

    private int id;
    private String titulo;
    private String descricao;
    private LocalDate dataConclusao;

    public Tarefa(String titulo, String descricao, LocalDate dataConclusao) {
        this.id = contador++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataConclusao = dataConclusao;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(LocalDate dataConclusao) { this.dataConclusao = dataConclusao; }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Título: " + titulo +
               " | Descrição: " + descricao +
               " | Concluir até: " + dataConclusao;
    }
}
