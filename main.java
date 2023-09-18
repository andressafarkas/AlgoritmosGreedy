import java.util.ArrayList;
import java.util.List;

public class main {

        public static void main(String[] args) {
        // Exemplo de uso:

        Problema1 p1 = new Problema1();
        List<Emprestimo> empréstimos = new ArrayList<>();
        empréstimos.add(new Emprestimo(1, 1.05));
        empréstimos.add(new Emprestimo(2, 1.1));
        empréstimos.add(new Emprestimo(3, 1.08));

        List<Integer> ordemPagamento = p1.calcularOrdemPagamento(empréstimos);

        System.out.println("Ordem de pagamento dos empréstimos:");
        for (Integer id : ordemPagamento) {
            System.out.println("Empréstimo " + id);
        }
    }
    
}
