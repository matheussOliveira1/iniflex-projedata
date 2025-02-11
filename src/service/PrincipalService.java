package service;

import models.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;

public class PrincipalService {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void addFuncionario(Funcionario f){
        if (f != null) funcionarios.add(f);
    }

    public void removerPorNome(String nome) {
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    public List<Funcionario> getFuncionarios () {
        return funcionarios;
    }

    public List<Funcionario> aumentoSalario () {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal(0.10));
            BigDecimal aumentoArredondado = aumento.setScale(2, RoundingMode.UP);
            funcionario.setSalario(funcionario.getSalario().add(aumentoArredondado));
        }
        return funcionarios;
    }

    private Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionariosDesorganizado) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario f : funcionariosDesorganizado) {
            funcionariosPorFuncao
                    .computeIfAbsent(f.getFuncao(), k -> new ArrayList<>())
                    .add(f);
        }

        return funcionariosPorFuncao;
    }

    public String getAllPorFuncao(List<Funcionario> funcionariosDesorganizado) {
        Map<String, List<Funcionario>> listaOrganizada = agruparPorFuncao(funcionariosDesorganizado);

        return listaOrganizada.toString();
    }

    public List<Funcionario> getAllPorMesDeNascimento(List<Funcionario> funcionarios, Month primeiroMes, Month segundoMes) {
        List<Funcionario> funcionariosPorMes = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().getMonth().equals(primeiroMes) || f.getDataNascimento().getMonth().equals(segundoMes)) {
                funcionariosPorMes.add(f);
            }
        }
        return funcionariosPorMes;
    }

    public String getFuncionarioComMaiorIdade (List<Funcionario> funcionarios) {
        int indiceFuncionarioMaiorIdade = 0;
        for (int i = 1; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getDataNascimento().getYear()
                    < funcionarios.get(indiceFuncionarioMaiorIdade).getDataNascimento().getYear()) {
                indiceFuncionarioMaiorIdade = i;
            }
        }

        Period periodo = Period.between(funcionarios.get(indiceFuncionarioMaiorIdade).getDataNascimento(), LocalDate.now());

        return "Nome: " + funcionarios.get(indiceFuncionarioMaiorIdade).getNome() + "\nIdade: " + periodo.getYears();
    }

    public List<Funcionario> getAllOrdemAlfabetica(List<Funcionario> funcionarios) {
        List<Funcionario> funcionariosOrganizadoPorAlfabeto = funcionarios;
        Collections.sort(funcionariosOrganizadoPorAlfabeto);
        return funcionariosOrganizadoPorAlfabeto;
    }

    public Double getSumSalarioTotal(List<Funcionario> funcionarios) {
        double total = 0.0;
        for (int i = 0; i < funcionarios.size(); i++) {
            total += funcionarios.get(i).getSalario().doubleValue();
        }
        return (double) Math.round(total);
    }

    public List<String> getQuantidadeSalariosMinimoPorFuncionario (List<Funcionario> funcionarios) {
        List<String> salariosMinimosPorFuncionario = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            double quantidadeSalariosMinimos = Math.round(f.getSalario().doubleValue() / 1212.00);
            salariosMinimosPorFuncionario.add(
                    "\n" + f.getNome()
                            + ", Quantidade de salarios minimos: "
                            + quantidadeSalariosMinimos
            );
        }
        return salariosMinimosPorFuncionario;
    }

}
