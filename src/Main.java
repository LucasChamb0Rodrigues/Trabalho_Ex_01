import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorQuadra sistema = new GerenciadorQuadra();

        // Listas para armazenar o que foi cadastrado durante a execução
        List<Cliente> clientesCadastrados = new ArrayList<>();
        List<Horario> horariosDisponiveis = new ArrayList<>();

        int opcao = 0;

        System.out.println("=== SISTEMA DE CONTROLE DE QUADRA ===");

        do {
            System.out.println("\n1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Horário Disponível");
            System.out.println("3. Registrar Aluguel");
            System.out.println("4. Consultar Aluguéis do Dia");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do Cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String tel = scanner.nextLine();
                        clientesCadastrados.add(new Cliente(nome, tel));
                        System.out.println("Cliente cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Horário (ex: 14:00): ");
                        String hora = scanner.nextLine();
                        System.out.print("Valor da hora: ");
                        double valor = Double.parseDouble(scanner.nextLine());
                        horariosDisponiveis.add(new Horario(hora, valor));
                        System.out.println("Horário configurado!");
                        break;

                    case 3:
                        if (clientesCadastrados.isEmpty() || horariosDisponiveis.isEmpty()) {
                            System.out.println("Erro: Cadastre pelo menos um cliente e um horário primeiro.");
                            break;
                        }

                        // Listar clientes para seleção
                        System.out.println("\nSelecione o Cliente:");
                        for (int i = 0; i < clientesCadastrados.size(); i++) {
                            System.out.println(i + " - " + clientesCadastrados.get(i).getNome());
                        }
                        int cliIndex = Integer.parseInt(scanner.nextLine());

                        // Listar horários para seleção
                        System.out.println("\nSelecione o Horário:");
                        for (int i = 0; i < horariosDisponiveis.size(); i++) {
                            Horario h = horariosDisponiveis.get(i);
                            String status = h.isOcupado() ? "[OCUPADO]" : "[LIVRE]";
                            System.out.println(i + " - " + h.getHora() + " - R$" + h.getValor() + " " + status);
                        }
                        int horIndex = Integer.parseInt(scanner.nextLine());

                        Cliente c = clientesCadastrados.get(cliIndex);
                        Horario h = horariosDisponiveis.get(horIndex);

                        sistema.registrarAluguel(c, h, LocalDate.now());

                        // Mostrar total acumulado do cliente no dia
                        double total = sistema.calcularTotalClienteNoDia(c, LocalDate.now());
                        System.out.println("Total acumulado de " + c.getNome() + " hoje: R$ " + total);
                        break;

                    case 4:
                        sistema.consultarAlugueisPorData(LocalDate.now());
                        break;

                    case 0:
                        System.out.println("Encerrando sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("ERRO: Entrada inválida ou dados incorretos. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}