import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GerenciadorQuadra {
    private List<Aluguel> alugueis = new ArrayList<>();

    public void registrarAluguel(Cliente cliente, Horario horario, LocalDate data) {
        // Regra: Não permitir reservar horário ocupado
        if (horario.isOcupado()) {
            System.out.println("ERRO: O horário das " + horario.getHora() + " já está ocupado!");
            return;
        }

        Aluguel novoAluguel = new Aluguel(cliente, horario, data);
        alugueis.add(novoAluguel);
        horario.setOcupado(true);
        System.out.println("Aluguel realizado com sucesso para " + cliente.getNome());
    }

    public double calcularTotalClienteNoDia(Cliente cliente, LocalDate data) {
        return alugueis.stream()
                .filter(a -> a.getCliente().equals(cliente) && a.getData().equals(data))
                .mapToDouble(a -> a.getHorario().getValor())
                .sum();
    }

    public void consultarAlugueisPorData(LocalDate data) {
        System.out.println("\n--- Aluguéis do dia " + data + " ---");
        alugueis.stream()
                .filter(a -> a.getData().equals(data))
                .forEach(System.out::println);
    }
}