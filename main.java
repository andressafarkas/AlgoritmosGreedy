import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
            Random random = new Random();
        
        int N = 4; // Definindo o tamanho da Matriz

        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
 
        // Preencha as matrizes A e B com números inteiros aleatórios
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = random.nextInt(100); // Gere números inteiros aleatórios de 0 a 99
                B[i][j] = random.nextInt(100);
            }
        }
 
        int[][] C = p2.multiply(A, B);
        
        System.out.println("Matriz A:");
        printMatrix(A);
 
        System.out.println("Matriz B:");
        printMatrix(B);
        
        System.out.println("Multiplicação das Matrizes A e B: ");
        printMatrix(C);
    }
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
    
