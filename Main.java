package app;

import service.TarefaService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaService service = new TarefaService();

        while (true) {
            System.out.println("\n===== SISTEMA DE TAREFAS =====");
            System.out.println("1 - Cadastrar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            int opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();

                    System.out.print("Data conclusão (AAAA-MM-DD): ");
                    LocalDate data = LocalDate.parse(sc.nextLine());

                    service.criarTarefa(titulo, desc, data);
                    System.out.println("Tarefa criada!");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE TAREFAS ---");
                    service.listarTarefas().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("ID da tarefa a atualizar: ");
                    int idUp = Integer.parseInt(sc.nextLine());

                    System.out.print("Novo título: ");
                    String nt = sc.nextLine();

                    System.out.print("Nova descrição: ");
                    String nd = sc.nextLine();

                    System.out.print("Nova data (AAAA-MM-DD): ");
                    LocalDate ndt = LocalDate.parse(sc.nextLine());

                    if (service.atualizarTarefa(idUp, nt, nd, ndt))
                        System.out.println("Atualizado com sucesso!");
                    else
                        System.out.println("Tarefa não encontrada.");
                    break;

                case 4:
                    System.out.print("ID da tarefa a excluir: ");
                    int idDel = Integer.parseInt(sc.nextLine());

                    if (service.excluirTarefa(idDel))
                        System.out.println("Excluída!");
                    else
                        System.out.println("Tarefa não encontrada.");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
