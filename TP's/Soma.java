import java.util.Scanner;

/*
 * O programa vai lendo os numeros um por um e faz a soma dos algarismosde cada um. O metodo usa recursao para pegar os algarismos: 
ele usao resto da divisao por 10 para pegar o ultimo algarismo e depois divideo numero por 10 para continuar com o que sobrou. 
 Quando sobra somente um algarismo, ele retorna esse valor. O programa repete isso ate acabar todos os numeros da entrada.
 */

public class Soma {

    public static int sominha(int lanna) {
        if (lanna < 10) {
            return lanna;
        }

        return (lanna % 10) + sominha(lanna / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int lanna = sc.nextInt();

            System.out.println(sominha(lanna));
        }

        sc.close();
    }
}