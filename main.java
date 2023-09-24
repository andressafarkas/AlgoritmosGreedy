import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Problema1.OrdemPagamento;
public class main {
        public static void main(String[] args) {

        List<Double> taxasJuros = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos empréstimos foram contratados? ");
        int num_emprestimos = scanner.nextInt();

        for (int i = 0; i < num_emprestimos; i++) {
            System.out.println("Qual a taxa de juros do empréstimo " + i + " ? ");
            taxasJuros.add(scanner.nextDouble());
        }

        System.out.println(taxasJuros);

 
        System.out.println("Ordem de pagamento dos empréstimos");
        for (Integer id : OrdemPagamento.menorCustoTotal(taxasJuros)) {
            System.out.println("Empréstimo: " + id);
        }
    }
}
