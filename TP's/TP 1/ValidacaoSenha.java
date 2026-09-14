
import java.util.Scanner;

/*
 O programa vai lendo as senhas uma por uma ate aparecer "FIM".
 Para cada senha, ele percorre os caracteres usando um for e vai verificando se existe pelo menos uma letra maiuscula, uma minuscula,um numero e um caractere especial. Tambem verifica se a senha possuipelo menos 8 caracteres. Depois de fazer essas verificacoes, o programa mostra "SIM" se a senha passar em todos os requisitos e "NAO" caso contrario.
 */

public class ValidacaoSenha {

    public static boolean ehFim(String lannaEntrada) {
        if (lannaEntrada.length() != 3) {
            return false;
        }

        return lannaEntrada.charAt(0) == 'F' &&
               lannaEntrada.charAt(1) == 'I' &&
               lannaEntrada.charAt(2) == 'M';
    }

    public static boolean validaSenha(String lannaTexto) {
        int tamanho = lannaTexto.length();

        if (tamanho < 8) {
            return false;
        }

        int maiuscula = 0;
        int minuscula = 0;
        int numero = 0;
        int especial = 0;

        for (int i = 0; i < tamanho; i++) {
            char lannaChar = lannaTexto.charAt(i);

            if (lannaChar >= 'A' && lannaChar <= 'Z') {
                maiuscula++;
            } else if (lannaChar >= 'a' && lannaChar <= 'z') {
                minuscula++;
            } else if (lannaChar >= '0' && lannaChar <= '9') {
                numero++;
            } else {
                especial++;
            }
        }

        return maiuscula > 0 && minuscula > 0 && numero > 0 && especial > 0;
    }

    public static void main(String[] args) {
        Scanner leitorzinho = new Scanner(System.in);

        while (leitorzinho.hasNextLine()) {
            String lannaLinha = leitorzinho.nextLine();

            if (ehFim(lannaLinha)) {
                break;
            }

            if (validaSenha(lannaLinha)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }

        leitorzinho.close();
    }
}

