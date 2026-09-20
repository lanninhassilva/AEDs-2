public /*
Esse programa ordena os veiculos pela cilindrada usando o Bucketsort.

Primeiro leio os veiculos do arquivo csv e recebo os ids pelo teclado até o usuario digitar -1. Cada id é pesquisado e, se for encontrado,
o veiculo é guardado no vetor que será ordenado.

No Bucketsort, crio 10 baldinhos, que são listas usadas para separar
os veiculos de acordo com a cilindrada normalizada pelo valor 8.1.

Depois percorro os veiculos e calculo em qual balde cada um deve ficar.
A divisão da cilindrada por 8.1 é convertida para inteiro e usada como indice do balde.

Quando todos os veiculos estão distribuidos, ordeno cada balde usando o algoritmo de inserção, comparando as cilindradas.

Por fim, percorro os baldes do primeiro ao ultimo e junto os veiculos novamente no vetor original. 
Assim eles ficam organizados pela cilindrada e podem ser impressos na ordem final.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Q7 {

    public static void ordenarBalde(ArrayList<Veiculo> balde) {
        for (int i = 1; i < balde.size(); i++) {
            Veiculo atual = balde.get(i);
            int j = i - 1;

            while (j >= 0 &&
                   balde.get(j).getCilindrada() > atual.getCilindrada()) {
                balde.set(j + 1, balde.get(j));
                j--;
            }

            balde.set(j + 1, atual);
        }
    }

    public static void bucketSort(Veiculo[] veiculos, int n) {
        ArrayList<Veiculo>[] baldes = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            baldes[i] = new ArrayList<Veiculo>();
        }

        for (int i = 0; i < n; i++) {
            double cilindrada = veiculos[i].getCilindrada();

            int indice = (int) (cilindrada / 8.1);

            if (indice < 0) {
                indice = 0;
            }

            if (indice > 9) {
                indice = 9;
            }

            baldes[indice].add(veiculos[i]);
        }

        for (int i = 0; i < 10; i++) {
            ordenarBalde(baldes[i]);
        }

        int posicao = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < baldes[i].size(); j++) {
                veiculos[posicao] = baldes[i].get(j);
                posicao++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Veiculo[] todos = LeitorCsv.ler();
        Veiculo[] selecionados = new Veiculo[todos.length];
        int n = 0;

        int id = sc.nextInt();

        while (id != -1) {
            for (int i = 0; i < todos.length; i++) {
                if (todos[i].getId() == id) {
                    selecionados[n] = todos[i];
                    n++;
                    break;
                }
            }

            id = sc.nextInt();
        }

        bucketSort(selecionados, n);

        for (int i = 0; i < n; i++) {
            System.out.println(selecionados[i].format());
        }

        sc.close();
    }
} {
    
}
