# Planejamento: Controle de Aluguel de Quadra Esportiva

Este projeto gerencia a locação de uma quadra de futebol society, substituindo o controle manual por um sistema automatizado seguindo o padrão MVC.

### Tabelas (Entidades) Identificadas
* **Cliente:** Armazena `nome` e `telefone`.
* **Horário:** Armazena a `hora` (String), o `valor` (double) e se está `ocupado` (boolean).
* **Aluguel:** Registra o vínculo entre um `Cliente`, um `Horário` e uma `Data`.

### Regras de Negócio Implementadas
* **Validação de Entrada:** Não permite cadastrar clientes com nome vazio ou horários com valor negativo.
* **Conflito de Agenda:** Não é possível reservar um horário que já esteja marcado como ocupado.
* **Cálculo Automático:** O sistema calcula o valor total gasto por um cliente no dia caso ele alugue mais de um horário.
* **Consulta:** Permite filtrar e visualizar todos os aluguéis realizados em uma data específica.