import java.util.Random;
import java.util.Scanner;

/*
O programa usa Scanner para ler as linhas e Random para sortear as duas letras que vão ser usadas na alteração. 
Ele fica lendo as linhas até aparecer "FIM". Para cada linha,sorteia duas letras minúsculas entre 'a' e 'z' e usa um for para percorrer todos os caracteres da frase.
Quando encontra a primeira letra sorteada, troca pela segunda.
No final, a frase modificada é montada em um vetor de char e transformada novamente em String para ser mostrada na tela.
 */

public class AlteracaoAleatoria {
public static boolean ehFim(String lannaEntrada) {
        if (lannaEntrada.length() != 3) {
            return false;
        }

        return lannaEntrada.charAt(0) == 'F'
                && lannaEntrada.charAt(1) == 'I'
                && lannaEntrada.charAt(2) == 'M';
    }

    public static String substituiAleatorio(String lannaTexto, Random geradorzinho) {

        char charOriginal = (char) ('a' + (Math.abs(geradorzinho.nextInt()) % 26));
        char charSubstituto = (char) ('a' + (Math.abs(geradorzinho.nextInt()) % 26));

        char[] resultadoFinal = new char[lannaTexto.length()];

        for (int i = 0; i < lannaTexto.length(); i++) {

            char charAtual = lannaTexto.charAt(i);

            if (charAtual == charOriginal) {
                resultadoFinal[i] = charSubstituto;
            } else {
                resultadoFinal[i] = charAtual;
            }
        }

        return new String(resultadoFinal);
    }

    public static void main(String[] args) {

        Scanner leitorzinho = new Scanner(System.in);

        Random aleatoriozinho = new Random();
        aleatoriozinho.setSeed(4);

        while (leitorzinho.hasNextLine()) {

            String lannaLinha = leitorzinho.nextLine();

            if (ehFim(lannaLinha)) {
                break;
            }

            String lannaModificada =
                substituiAleatorio(lannaLinha, aleatoriozinho);

            System.out.println(lannaModificada);
        }

        leitorzinho.close();
    }
}