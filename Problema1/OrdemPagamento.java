package Problema1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdemPagamento {
    
    public static List<Integer> menorCustoTotal(List<Double> taxasJuros) {
        int n = taxasJuros.size();
        List<Emprestimo> emprestimos = new ArrayList<>();

        // Criar uma lista de empréstimos com seus índices e taxas de juros correspondentes
        for (int i = 0; i < n; i++) {
            emprestimos.add(new Emprestimo(i + 1, taxasJuros.get(i)));
        }

        // Ordenar os empréstimos com base nas taxas de juros em ordem crescente
        Collections.sort(emprestimos, Comparator.comparingDouble(emprestimo -> emprestimo.taxaDeJuros));

        List<Integer> ordemPagamento = new ArrayList<>();
        //double custoTotal = 0;

        // Pagar os empréstimos em ordem crescente de taxa de juros
        for (Emprestimo emprestimo : emprestimos) {
            ordemPagamento.add(emprestimo.id);
            //custoTotal += Math.pow(emprestimo.taxaDeJuros, ordemPagamento.size() - 1) * 1000;
        }

        return ordemPagamento;
        
    }

}
