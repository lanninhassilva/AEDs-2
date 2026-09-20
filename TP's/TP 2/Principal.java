/*
Primeiro eu leio o arquivo csv usando a classe LeitorCsv.
Assim todos os veiculos ficam guardados em um vetor e podem ser pesquisados quando o usuario digitar um id.

Depois uso o Scanner pra receber os ids pelo teclado.
O programa fica lendo os valores enquanto o usuario não digitar -1, que é o valor usado pra encerrar a execução.

Pra encontrar um veiculo, uso a pesquisa sequencial.
Ela percorre o vetor desde o começo, comparando o id digitado com o id de cada veiculo.

Quando encontra um id igual, retorna o veiculo encontrado. Se terminar de percorrer o vetor e não achar, retorna null.
*/
import java.util.Scanner;

public class Principal {

    public static Veiculo pesquisar(
        Veiculo[] veiculos,
        int id
    ) {
        for (int i = 0; i < veiculos.length; i++) {

            if (veiculos[i].getId() == id) {
                return veiculos[i];
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Veiculo[] veiculos =
            LeitorCsv.ler("/tmp/veiculos.csv");

        while (sc.hasNextInt()) {
            int id = sc.nextInt();

            if (id == -1) {
                break;
            }

            Veiculo encontrado =
                pesquisar(veiculos, id);

            if (encontrado != null) {
                System.out.println(encontrado.format());
            }
        }

        sc.close();
    }
}