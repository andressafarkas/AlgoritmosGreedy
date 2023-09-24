import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Problema2.Problema2;
import Problema1.OrdemPagamento;
public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);   

        // PROGRAMA 1

        List<Double> taxasJuros = new ArrayList<>();

        System.out.println("Quantos empréstimos foram contratados? ");
        int num_emprestimos = scanner.nextInt();

        for (int i = 0; i < num_emprestimos; i++) {
            System.out.println("Qual a taxa de juros do empréstimo " + i + " ? ");
            taxasJuros.add(scanner.nextDouble());
        }

        System.out.println("Ordem de pagamento dos empréstimos");
        for (Integer id : OrdemPagamento.menorCustoTotal(taxasJuros)) {
            System.out.println("Empréstimo: " + id);
        }

        // PROGRAMA 2

        System.out.println("Implementação do algoritmo de multiplicação de Strassen para multiplicação de Matrizes:");
        
        Problema2 p2 = new Problema2();
 
        int N = 4; // Definindo o tamanho da Matriz

        int[][] A = { { 1, 2, 3, 4 },
                      { 4, 3, 0, 1 },
                      { 5, 6, 1, 1 },
                      { 0, 2, 5, 6 } };
 
        int[][] B = { { 1, 0, 5, 1 },
                      { 1, 2, 0, 2 },
                      { 0, 3, 2, 3 },
                      { 1, 2, 1, 2 } };
 
        int[][] C = p2.multiply(A, B);
        
        System.out.println("Multiplicação das Matrizes A e B: ");
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(C[i][j] + " ");
            System.out.println();
        }
        scanner.close();
    }
}
    
