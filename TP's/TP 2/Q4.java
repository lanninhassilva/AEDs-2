/*
Esse programa ordena os veiculos pela marca usando o algoritmo de ordenação por inserção.

Primeiro leio os veiculos do arquivo csv e depois recebo os ids igitados pelo usuario, até aparecer -1, que encerra a leitura.

Cada id é pesquisado no vetor de veiculos. Quando encontro guardo o veiculo em outro vetor, que vai ser usado na ordenação.

Na ordenação por inserção, começo pelo segundo elemento e guardoele numa variavel auxiliar. Depois comparo sua marca com as marcas
dos elementos anteriores. Se alguma marca for maior, eu desloco esse veiculo uma posição pra frente.

Quando encontro a posição certa, coloco o veiculo que estava guardado.
Repito isso até todos estarem ordenados pela marca.

No final, imprimo os veiculos na ordem encontrada.
*/

import java.util.Scanner;

public class Q4 {

    public static void ordenarPorInsercao(Veiculo[] veiculos, int n) {
        for (int i = 1; i < n; i++) {
            Veiculo atual = veiculos[i];
            int j = i - 1;

            while (j >= 0 &&
                   veiculos[j].getMarca().compareTo(atual.getMarca()) > 0) {
                veiculos[j + 1] = veiculos[j];
                j--;
            }

            veiculos[j + 1] = atual;
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

        ordenarPorInsercao(selecionados, n);

        for (int i = 0; i < n; i++) {
            System.out.println(selecionados[i].format());
        }

        sc.close();
    }
}