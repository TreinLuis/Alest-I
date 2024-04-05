import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivosCsv {
    public static void main(String[] args) throws IOException {
        new LerArquivosCsv().iniciar();
    }

    private void iniciar() {// Complexidade de iniciar é N
        String filePath = "dados.csv"; // Certifique-se de que o caminho do arquivo está correto
        int[][] matrizVendas = new int[4][12]; // Supondo 4 lojas e 12 meses

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Pular cabeçalho
            while ((line = br.readLine()) != null) { // Ler linha por linha     N
                String[] colunas = line.split(",");
                String nomeLoja = colunas[2];
                String nomeMes = colunas[1];
                int valor = Integer.parseInt(colunas[3]);

                int indiceLoja = getIndiceLoja(nomeLoja);//metodo para pegar o indice da nossa filial atravez da string
                int indiceMes = getIndiceMes(nomeMes);//metodo para pegar o indice do nosso mes atravez da string
                if (indiceLoja != -1 && indiceMes != -1) {//verifica se existe as filias e meses
                    matrizVendas[indiceLoja][indiceMes] += valor; // Acumular valor para loja e mês
                }
                //OBS ISSO TUDO É FEITO NO WHILE, OU SEJA A CADA LINHA QUE LENAS FAZEMOS ESTE IF E COLOCAMOS VALOR NA NOSSA MATRIZ COM BASE NOS INDICES ENCONTRADOS

            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        imprimirMatrizVendas(matrizVendas);
        imprimirTop3MesesComMaisVenda(matrizVendas);
        mesMenorVenda(matrizVendas);
        mediaDeTransacoes(matrizVendas);
    }

    private int getIndiceLoja(String nomeLoja) {// 1
        switch (nomeLoja) {
            case "Matriz":
                return 0;
            case "Filial Sul":
                return 1;
            case "Filial Norte":
                return 2;
            case "Filial Nordeste":
                return 3;
            default:
                return -1; // Loja não encontrada
        }
    }

    private int getIndiceMes(String nomeMes) {//1
        switch (nomeMes) {
            case "Janeiro":
                return 0;
            case "Fevereiro":
                return 1;
            case "Marco":
                return 2;
            case "Abril":
                return 3;
            case "Maio":
                return 4;
            case "Junho":
                return 5;
            case "Julho":
                return 6;
            case "Agosto":
                return 7;
            case "Setembro":
                return 8;
            case "Novembro":
                return 9;
            case "Outobro":
                return 10;
            case "Dezembro":
                return 11;
            default:
                return -1; // Mês não encontrado
        }
    }

    private void imprimirMatrizVendas(int[][] matrizVendas) {//nˆ3
        // Definir os nomes das filiais e dos meses na ordem correta
        String[] nomesFilias = {"Matriz", "Filial Nordeste", "Filial Norte", "Filial Sul"};
        String[] nomesMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        // Primeiro, imprimir a linha de cabeçalho para os meses
        System.out.printf("%-15s", "Loja/Mês"); // Espaço reservado para o nome da filial
        for (String mes : nomesMeses) {//n
            System.out.printf("%-10s", mes); // Espaço para os meses
        }
        System.out.println(); // Quebrar a linha após imprimir todos os meses

        // Agora, imprimir as vendas por filial e por mês
        for (int i = 0; i < matrizVendas.length; i++) {//nˆ2
            System.out.printf("%-17s", nomesFilias[i]); // Nome da filial
            for (int j = 0; j < matrizVendas[i].length; j++) {//nˆ3
                System.out.printf("%-10d", matrizVendas[i][j]); // Vendas do mês
            }
            System.out.println(); // Quebrar a linha após cada filial
        }
    }

    private void imprimirTop3MesesComMaisVenda(int[][] matrizVendas) {
        String[] nomesMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        int[] somaVendasPorMes = new int[12];

        // Calcular a soma das vendas para cada mês.
        for (int mes = 0; mes < 12; mes++) {
            for (int filial = 0; filial < matrizVendas.length; filial++) {
                somaVendasPorMes[mes] += matrizVendas[filial][mes];
            }
        }

        // Inicializar um array para os top 3 meses e suas vendas.
        int[] top3Vendas = {0, 0, 0};
        String[] top3Meses = {"", "", ""};

        for (int mes = 0; mes < 12; mes++) {
            int vendaAtual = somaVendasPorMes[mes];
            for (int i = 0; i < 3; i++) {
                if (vendaAtual > top3Vendas[i]) {
                    // Deslocar os valores e meses para abrir espaço para o novo top vendas.
                    for (int j = 2; j > i; j--) {
                        top3Vendas[j] = top3Vendas[j - 1];
                        top3Meses[j] = top3Meses[j - 1];
                    }
                    // Inserir o novo top vendas.
                    top3Vendas[i] = vendaAtual;
                    top3Meses[i] = nomesMeses[mes];
                    break; // Parar a verificação após inserir o novo valor.
                }
            }
        }

        // Imprimir os 3 meses com mais vendas.
        System.out.println("Os 3 meses com mais vendas são:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + top3Meses[i] + " com " + top3Vendas[i] + " vendas");
        }
    }

    private void mesMenorVenda(int[][] matrizVendas) {
        String[] nomesMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        int[] somaVendasPorMes = new int[12];

        // Calcular a soma das vendas para cada mês.
        for (int mes = 0; mes < 12; mes++) {
            for (int filial = 0; filial < matrizVendas.length; filial++) {
                somaVendasPorMes[mes] += matrizVendas[filial][mes];
            }
        }

        // Inicializa com o primeiro mês como tendo a menor venda.
        int mesMenorVenda = 0;
        for (int mes = 1; mes < 12; mes++) {
            // Se encontrar um mês com vendas iguais e menos recente, ou vendas menores, atualize.
            if (somaVendasPorMes[mes] <= somaVendasPorMes[mesMenorVenda]) {
                mesMenorVenda = mes;
            }
        }
        // Imprimir o mês com menor venda. Em caso de empate, o menos recente será escolhido.
        System.out.println("Mês com menor venda: " + nomesMeses[mesMenorVenda] +
                " (Vendas: " + somaVendasPorMes[mesMenorVenda] + ")");
    }

    private void mediaDeTransacoes(int[][] matrizVendas) {
        int totalVendas = 0;
        int totalTransacoes = 0;

        // Calcular a soma total das vendas e contar o número de transações.
        for (int filial = 0; filial < matrizVendas.length; filial++) {
            for (int mes = 0; mes < matrizVendas[filial].length; mes++) {
                // Considera cada valor na matriz como uma venda/transação.
                totalVendas += matrizVendas[filial][mes];
                // Conta apenas se houver uma venda (valor maior que 0).
                if (matrizVendas[filial][mes] > 0) {
                    totalTransacoes++;
                }
            }
        }
        // Calcular a média de vendas por transação.
        double media = (totalTransacoes > 0) ? (double) totalVendas / totalTransacoes : 0;

        System.out.printf("Média de vendas por transação: %.2f\n", media);
    }
}
