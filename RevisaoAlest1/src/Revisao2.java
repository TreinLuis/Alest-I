/*
Construa um vetor que recebe 10 valores inteiros lidos através do teclado.
Exiba o vetor resultante na ordem inversa da qual os dados estão inseridos.
Após, leia um número inteiro e procure por este valor no vetor respeitando
a ordem na qual os dados foram inseridos. Se encontrar, exiba o número lido
e o índice da primeira ocorrência deste valor. Se não encontrar, exiba a mensagem
"Valor X não encontrado" onde o X é o número lido.
 */

import java.util.Scanner;

public class Revisao2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean achou = false;
        int valorPesquisa;
        int[] vetor = new int[10];
        int[] vetorInvertido = new int[10];
        System.out.println("Hello");

        for(int i = 1;i<11;i++){
            System.out.println("Digite um valor para a posição "+ i + " do vetor");
            vetor[i-1] = in.nextInt();
        }
        for(int i = 0;i<10; i++){
            vetorInvertido[i] = vetor[10-i-1];
            System.out.println(vetorInvertido[i]);
        }

        System.out.println("Agora digite um valor para pesquisar o índice no vetor: ");
        valorPesquisa = in.nextInt();

            for(int i = 0; i<10;i++){
                if(valorPesquisa == vetor[i]){
                    achou = true;
                    System.out.println("O valor "+valorPesquisa+ " foi encontrado na posição: "+i);
                }
            }
        if(!achou){
            System.out.println("Valor "+valorPesquisa+" não encontrado");
        }
    }

}


