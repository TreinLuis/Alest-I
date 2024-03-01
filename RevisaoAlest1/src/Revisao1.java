/*
a) Uma concessionária está oferecendo descontos nos preços dos seus veículos de acordo com o tipo de combustível.
Os descontos estão estruturados da seguinte forma: para veículos com álcool são 25% , com gasolina são 21% e com
diesel são 14%. Crie uma função que receba o valor do veículo e o tipo de combustível e retorne o resultado do cálculo do
valor de desconto. Crie também uma função que calcule e retorne o valor a ser pago pelo cliente com o desconto. Exiba o valor
do carro sem desconto, o desconto concedido, o valor do desconto e o valor do carro com desconto.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Revisao1 {

    public static void main(String[] args) {
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(stream);
        String tipoVeiculo = "";
        double valor = 0.0;
        double valorDoDesconto = 0.0;
        double valorTotal;


        System.out.printf("Hello! \nDigite o tipo de combustivel utilizado(Diesel/Gasolina/Álcool): ");
        try {

            tipoVeiculo = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Digite o valor do veículo: ");
        try {
            valor = Double.valueOf(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        valorDoDesconto = desconto(tipoVeiculo,valor);
        valorTotal = valorFinal(valorDoDesconto,valor);

        System.out.println("O veículo desejado custa: "+ valor);
        System.out.println("O desconto deste veículo: "+ valorDoDesconto);
        System.out.println("O valor final deste veículo: "+ valorTotal);

    }
    public static double desconto(String tipoVeiculo, double valor){
        double valorDoDesconto = 0.0;
        if(tipoVeiculo.equalsIgnoreCase("diesel")){
            valorDoDesconto = valor*0.14;
        } else if (tipoVeiculo.equalsIgnoreCase("gasolina")) {
            valorDoDesconto = valor*0.21;
        } else {
            valorDoDesconto = valor*0.25;
        }
        return Math.round(valorDoDesconto);
    }

    public static double valorFinal(double desconto, double valor){
        double valorTotal;
        valorTotal = valor-desconto;

        return valorTotal;
    }
}