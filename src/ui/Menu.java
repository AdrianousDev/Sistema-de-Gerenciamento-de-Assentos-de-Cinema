package ui;

import model.Cadeira;
import model.Sala;
import service.CinemaService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private CinemaService cinemaService;

    public Menu(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;

        while (true) {
            mostrarMenu();

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException erro) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            System.out.println();

            try {
                switch (opcao) {
                    case 1:
                        listarSalas();
                        break;

                    case 2:
                        visualizarCadeiras();
                        break;

                    case 3:
                        reservarCadeira();
                        break;

                    case 4:
                        liberarCadeira();
                        break;

                    case 5:
                        cadastrarSala();
                        break;

                    case 0:
                        System.out.println("Encerrando sistema...");
                        return;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (RuntimeException erro) {
                System.out.println("Erro: " + erro.getMessage());
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Listar salas");
        System.out.println("2 - Visualizar cadeiras");
        System.out.println("3 - Reservar cadeira");
        System.out.println("4 - Liberar cadeira");
        System.out.println("5 - Cadastrar sala");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private void listarSalas() {
        List<Sala> salas = cinemaService.listarSalas();

        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada.");
            return;
        }

        for (Sala sala : salas) {
            System.out.println("- " + sala.getNome());
        }
    }

    private void visualizarCadeiras() {
        System.out.print("Nome da sala: ");
        String nomeSala = scanner.nextLine();

        Sala sala = cinemaService.buscarSalaPorNome(nomeSala);
        imprimirCadeiras(sala);
    }

    private void imprimirCadeiras(Sala sala) {
        int count = 0;

        for (Cadeira cadeira : sala.getCadeiras()) {
            System.out.print(cadeira + " ");

            count++;

            if (count == sala.getColunas()) {
                System.out.println();
                count = 0;
            }
        }
    }

    private void reservarCadeira() {
        System.out.print("Sala: ");
        String nomeSala = scanner.nextLine();

        System.out.print("Cadeira: ");
        String codigo = scanner.nextLine();

        cinemaService.reservarCadeira(nomeSala, codigo);

        System.out.println("Reserva realizada.");
    }

    private void liberarCadeira() {
        System.out.print("Sala: ");
        String nomeSala = scanner.nextLine();

        System.out.print("Cadeira: ");
        String codigo = scanner.nextLine();

        cinemaService.liberarCadeira(nomeSala, codigo);

        System.out.println("Cadeira liberada.");
    }

    private void cadastrarSala() {
        System.out.print("Nome da sala: ");
        String nome = scanner.nextLine();

        int fileiras = lerInteiro("Quantidade de fileiras: ");
        int colunas = lerInteiro("Quantidade de colunas: ");

        cinemaService.cadastrarSala(nome, fileiras, colunas);

        System.out.println("Sala cadastrada com sucesso.");
    }

    private int lerInteiro(String mensagem) {
        System.out.print(mensagem);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException erro) {
            throw new RuntimeException("Digite um número válido.");
        }
    }
}