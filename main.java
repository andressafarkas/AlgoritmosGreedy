import java.util.ArrayList;
import java.util.List;

import Problema1.OrdemPagamento;
public class main {
        public static void main(String[] args) {

        List<Double> taxasJuros = new ArrayList<>();
        taxasJuros.add(1.1);
        taxasJuros.add(1.05);
        taxasJuros.add(1.2);
       
        System.out.println("Ordem de pagamento dos empréstimos");
        for (Integer id : OrdemPagamento.menorCustoTotal(taxasJuros)) {
            System.out.println("Empréstimo: " + id);
        }
    }
}
