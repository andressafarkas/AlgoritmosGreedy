public class Problema2 {
    public class StrassenMatrixMultiplication {
        public static int[][] multiply(int[][] A, int[][] B) {
            int n = A.length;
            
            // Verifica se as matrizes são de tamanho n x n e n é uma potência de 2
            if (n <= 1) {
                int[][] C = new int[1][1];
                C[0][0] = A[0][0] * B[0][0];
                return C;
            }
            
            // Divide as matrizes em quatro submatrizes
            int newSize = n / 2;
            int[][] A11 = new int[newSize][newSize];
            int[][] A12 = new int[newSize][newSize];
            int[][] A21 = new int[newSize][newSize];
            int[][] A22 = new int[newSize][newSize];
            int[][] B11 = new int[newSize][newSize];
            int[][] B12 = new int[newSize][newSize];
            int[][] B21 = new int[newSize][newSize];
            int[][] B22 = new int[newSize][newSize];
    
            // Preenche as submatrizes
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    A11[i][j] = A[i][j];
                    A12[i][j] = A[i][j + newSize];
                    A21[i][j] = A[i + newSize][j];
                    A22[i][j] = A[i + newSize][j + newSize];
                    B11[i][j] = B[i][j];
                    B12[i][j] = B[i][j + newSize];
                    B21[i][j] = B[i + newSize][j];
                    B22[i][j] = B[i + newSize][j + newSize];
                }
            }
    
            // Calcula produtos intermediários
            int[][] P1 = multiply(A11, subtract(B12, B22));
            int[][] P2 = multiply(add(A11, A12), B22);
            int[][] P3 = multiply(add(A21, A22), B11);
            int[][] P4 = multiply(A22, subtract(B21, B11));
            int[][] P5 = multiply(add(A11, A22), add(B11, B22));
            int[][] P6 = multiply(subtract(A12, A22), add(B21, B22));
            int[][] P7 = multiply(subtract(A11, A21), add(B11, B12));
    
            // Calcula as submatrizes do resultado
            int[][] C11 = subtract(add(add(P5, P4), P6), P2);
            int[][] C12 = add(P1, P2);
            int[][] C21 = add(P3, P4);
            int[][] C22 = subtract(subtract(add(P5, P1), P3), P7);
    
            // Combina as submatrizes para obter o resultado final
            int[][] C = new int[n][n];
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    C[i][j] = C11[i][j];
                    C[i][j + newSize] = C12[i][j];
                    C[i + newSize][j] = C21[i][j];
                    C[i + newSize][j + newSize] = C22[i][j];
                }
            }
    
            return C;
        }
    
        public static int[][] add(int[][] A, int[][] B) {
            int n = A.length;
            int[][] C = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    C[i][j] = A[i][j] + B[i][j];
                }
            }
            return C;
        }
    
        public static int[][] subtract(int[][] A, int[][] B) {
            int n = A.length;
            int[][] C = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    C[i][j] = A[i][j] - B[i][j];
                }
            }
            return C;
        }
    
        public static void main(String[] args) {
            int[][] A = {{1, 2}, {3, 4}};
            int[][] B = {{5, 6}, {7, 8}};
            int[][] C = multiply(A, B);
    
            System.out.println("Resultado da multiplicação:");
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[i].length; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        }
    }    
}
