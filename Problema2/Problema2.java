package Problema2;

public class Problema2 {
 
    // Funcao de multiplicacao de Matrizes
    public int[][] multiply(int[][] A, int[][] B) {
        
        int n = A.length; // Ordem da Matriz
        int[][] R = new int[n][n]; // Cria matriz de tamanho n
 
        if (n == 1) { // Caso Base (Apenas 1 elemento)
            R[0][0] = A[0][0] * B[0][0]; // Retorna a multiplicação simples entre dois elementos 
       
        }else { // Passo 1 - Dividir a Matriz em partes e armazenando em variaveis
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];
 
            // Passo 2: Dividir ambas as Matrizes em 4 metades
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
 
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);
  
            // M1 = (A1 + A3) × (B1 + B2)
            int[][] M1 = multiply(add(A11, A22), add(B11, B22));
           
            // M2 = (A2 + A4) × (B3 + B4)
            int[][] M2 = multiply(add(A21, A22), B11);
           
            // M3 = (A1 − A4) × (B1 + A4)
            int[][] M3 = multiply(A11, sub(B12, B22));
           
            // M4 = A1 × (B2 − B4)
            int[][] M4 = multiply(A22, sub(B21, B11));
           
            // M5 = (A3 + A4) × (B1)
            int[][] M5 = multiply(add(A11, A12), B22);
           
            // M6 = (A1 + A2) × (B4)
            int[][] M6 = multiply(sub(A21, A11), add(B11, B12));
           
            // M7 = A4 × (B3 − B1)
            int[][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            // P = M2 + M3 − M6 − M7
            int[][] C11 = add(sub(add(M1, M4), M5), M7);
           
            // Q = M4 + M6
            int[][] C12 = add(M3, M5);
           
            // R = M5 + M7
            int[][] C21 = add(M2, M4);
           
            // S = M1 − M3 − M4 − M5
            int[][] C22 = add(sub(add(M1, M3), M2), M6);
 
            // Passo 3: Juntar as 4 partes no resultado da Matriz
            join(C11, R, 0, 0);
            join(C12, R, 0, n / 2);
            join(C21, R, n / 2, 0);
            join(C22, R, n / 2, n / 2);
        }
        return R;  
    }
 
    // Funcao de subtracao de Matrizes
    public int[][] sub(int[][] A, int[][] B) {
       
        int n = A.length; // Ordem da Matriz
        int[][] C = new int[n][n]; // Cria matriz de tamanho n
 
        // Iterar os elementos atraves do loop 
        for (int i = 0; i < n; i++) { // Loop para as linhas
            for (int j = 0; j < n; j++) { // Loop para as colunas
                C[i][j] = A[i][j] - B[i][j]; // Subtrai os elementos correspondentes
             }
        } 
        return C;
    }
 
    // Funcao de adicao de Matrizes
    public int[][] add(int[][] A, int[][] B) {
        
        int n = A.length; // Ordem da Matriz
        int[][] C = new int[n][n]; // Cria matriz de tamanho n
 
        // Iterar os elementos atraves do loop 
        for (int i = 0; i < n; i++) { // Loop para as linhas
            for (int j = 0; j < n; j++) { // Loop para as colunas
                C[i][j] = A[i][j] + B[i][j];  // Soma os elementos correspondentes
            }
        }
        return C;
    }
 
    // Funcao para dividir a Matriz pai em Matrizes filhas
    public void split(int[][] P, int[][] C, int iB, int jB) { 
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) { // Loop para as linhas
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) { // Loop para as colunas
                C[i1][j1] = P[i2][j2]; // Copia o valor de P[i2][j2] para C[i1][j1]
            }
        }
    }
 
    // Funcao para juntas as Matrizes filhas em uma Matriz pai
    public void join(int[][] C, int[][] P, int iB, int jB) {    
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) { // Loop para as linhas
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) { // Loop para as colunas
                P[i2][j2] = C[i1][j1]; // Copia o valor de C[i1][j1] de volta para P[i2][j2]
            }
        }
    }
}
       