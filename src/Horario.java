public class Horario {
    private String hora; // Ex: "19:00"
    private double valor;
    private boolean ocupado;

    public Horario(String hora, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do horário não pode ser negativo.");
        }
        this.hora = hora;
        this.valor = valor;
        this.ocupado = false;
    }

    public String getHora() { return hora; }
    public double getValor() { return valor; }
    public boolean isOcupado() { return ocupado; }
    public void setOcupado(boolean ocupado) { this.ocupado = ocupado; }
}