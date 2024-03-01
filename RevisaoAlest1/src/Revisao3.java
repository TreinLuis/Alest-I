/*
c) Construa uma matriz de 5x4 que em cada posição receba um número randômico entre 0 e 99.
Exiba a matriz gerada de maneira adequada na tela. Depois, crie um vetor que armazene os
valores de todos os números pares da matriz e exiba o resultado do vetor. Use a classe
Random para geração de valores aleatórios.

 */

import java.util.Random;

public class Revisao3 {
    public static void main(String[] args) {
        Random rdm = new Random();
        int quantPares = 0;
        int[][] matriz = new int[5][4];
        int[] vetorPares;

        for(int i=0;i<5;i++){
            System.out.println("");
            for(int j=0;j<4;j++){
                matriz[i][j] = rdm.nextInt(100);
                System.out.print("[ "+matriz[i][j]+" ]");
                if(matriz[i][j]%2 ==0){
                    quantPares++;
                }
            }
        }
        vetorPares = new int[quantPares];
        int k=0;
        while(k<quantPares){
            for(int i=0;i<5;i++){
                for(int j=0;j<4;j++){
                    if(matriz[i][j] % 2 == 0){
                        vetorPares[k] = matriz[i][j];
                        k++;
                    }
                }
            }
        }
        for(int i=0;i<quantPares;i++){
            System.out.print("["+vetorPares[i]+"]");
        }
    }
}
