import java.util.Random;
import java.util.Scanner;

/*
Crie pequeno jogo de adivinhação onde inicialmente deve-se gerar um número aleatório inteiro entre 0 e 50 que será o
"número secreto". Em seguida solicite que o usuário digite um número inteiro. Se o número digitado for menor que o
número secreto, imprima “O número secreto é MAIOR”, se o número digitado for maior que o número secreto, imprima
“O número secreto é MENOR”. O usuário deve ter 10 tentativas de digitação de um número. Caso em algum momento ele acerte,
o sistema deve apresentar a mensagem "Parabéns, você acertou em X tentativas!" onde X é o número de tentativas que ele levou
para acertar e encerrar a execução. Caso o usuário não consiga acertar nas 10 tentativas, apresente uma mensagem desejando
"Boa sorte na próxima!".
 */
public class Revisao4 {
    public static void main(String[] args) {
        int cont = 1;
        Scanner in = new Scanner(System.in);
        int tentativas = 1;
        boolean acertou = false;
        int chute = 0;
        Random rdm = new Random();
        int numeroSecreto = rdm.nextInt(50);

        System.out.println("Bem Vindo ao game!!\nVoce tem 10 tentativas para acertar o número secreto!!");
        for(int i=1;i<=10;i++){
            System.out.println("Tentativa número " + i +" Digite um valor inteiro entre 0 e 50!");
            chute = in.nextInt();
            if(chute == numeroSecreto){
                acertou = true;
                break;
            } else if (chute<numeroSecreto){
                System.out.println("O número secreto é MAIOR");
                cont++;
            } else{
                System.out.println("O número secreto é MENOR");
                cont++;
            }
        }
        if(acertou){
            System.out.println("Parabéns, você acertou em "+ cont + " tentativas!");
        }else{
            System.out.println("Boa sorte na proxima!");
        }
    }
}
