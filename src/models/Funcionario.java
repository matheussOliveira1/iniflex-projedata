package models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa implements Comparable<Funcionario> {

    private BigDecimal salario;
    private String funcao;
    NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "\nFuncionario { " +
                "nome: " + getNome() +
                ", dataNascimento: " + dateTimeFormatter.format(getDataNascimento()) +
                ", salario: " + nf.format(salario) +
                ", funcao='" + funcao + " }";
    }

    @Override
    public int compareTo(Funcionario f) {
        return this.getNome().compareTo(f.getNome());
    }
}
