import java.time.LocalDate;

public class Aluguel {
    private Cliente cliente;
    private Horario horario;
    private LocalDate data;

    public Aluguel(Cliente cliente, Horario horario, LocalDate data) {
        this.cliente = cliente;
        this.horario = horario;
        this.data = data;
    }

    public Cliente getCliente() { return cliente; }
    public Horario getHorario() { return horario; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return "Data: " + data + " | Cliente: " + cliente.getNome() +
                " | Horário: " + horario.getHora() + " | Valor: R$ " + horario.getValor();
    }
}