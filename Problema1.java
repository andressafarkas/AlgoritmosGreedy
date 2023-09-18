import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Emprestimo {
    int id;
    double taxaDeJuros;

    public Emprestimo(int id, double taxaDeJuros) {
        this.id = id;
        this.taxaDeJuros = taxaDeJuros;
    }
}

public class Problema1 {

    public static List<Integer> calcularOrdemPagamento(List<Emprestimo> empréstimos) {
        List<Integer> ordemPagamento = new ArrayList<>();

        // Ordenar os emprestimos com base nas taxas de juros (do menor para o maior).
        Collections.sort(empréstimos, Comparator.comparingDouble(e -> e.taxaDeJuros));

        for (Emprestimo empréstimo : empréstimos) {
            ordemPagamento.add(empréstimo.id);
        }

        return ordemPagamento;
    }


}
