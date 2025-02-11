import models.Funcionario;
import service.PrincipalService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Principal {
    public static void main(String[] args) {

        PrincipalService gerente = new PrincipalService();

        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
        gerente.addFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        gerente.addFuncionario(new Funcionario("Joao", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        gerente.addFuncionario(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.38"), "Coordenador"));
        gerente.addFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        gerente.addFuncionario(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        gerente.addFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1587.72"), "Operador"));
        gerente.addFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Operador"));
        gerente.addFuncionario(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        gerente.addFuncionario(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        gerente.addFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        System.out.println(gerente.getFuncionarios());

        System.out.println("-".repeat(50));
        System.out.println("3.2 – Remover o funcionário “João” da lista.");
        System.out.println("-".repeat(50));
        gerente.removerPorNome("Joao");

        System.out.println("-".repeat(50));
        System.out.println("3.3 – Imprimir todos os funcionários com todas suas informações");
        System.out.println("-".repeat(50));
        System.out.println(gerente.getFuncionarios());
        System.out.println("\n");

        System.out.println("-".repeat(50));
        System.out.println("3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.");
        System.out.println("-".repeat(50));
        gerente.aumentoSalario();
        System.out.println(gerente.getFuncionarios());
        System.out.println("\n");

        System.out.println("-".repeat(50));
        System.out.println("3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.");
        System.out.println("3.6 – Imprimir os funcionários, agrupados por função.");
        System.out.println("-".repeat(50));
        System.out.println(gerente.getAllPorFuncao(gerente.getFuncionarios()));
        System.out.println("\n");

        System.out.println("-".repeat(50));
        System.out.println("3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
        System.out.println("-".repeat(50));
        System.out.println(gerente.getAllPorMesDeNascimento(gerente.getFuncionarios(), Month.OCTOBER, Month.DECEMBER));
        System.out.println("\n");

        System.out.println("-".repeat(50));
        System.out.println("3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
        System.out.println("-".repeat(50));
        System.out.println(gerente.getFuncionarioComMaiorIdade(gerente.getFuncionarios()));
        System.out.println("\n");

        System.out.println("-".repeat(50));
        System.out.println("3.10 – Imprimir a lista de funcionários por ordem alfabética.");
        System.out.println("-".repeat(50));
        System.out.println(gerente.getAllOrdemAlfabetica(gerente.getFuncionarios()));
        System.out.println("\n");

        System.out.println("-".repeat(50));
        System.out.println("3.11 – Imprimir o total dos salários dos funcionários.");
        System.out.println("-".repeat(50));
        System.out.println(gerente.getSumSalarioTotal(gerente.getFuncionarios()));
        System.out.println("\n");

        System.out.println("-".repeat(50));
        System.out.println("3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.");
        System.out.println("-".repeat(50));
        System.out.println(gerente.getQuantidadeSalariosMinimoPorFuncionario(gerente.getFuncionarios()));
        System.out.println("\n");

    }
}