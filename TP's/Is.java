import java.util.Scanner;

/*
 O programa vai lendo as linhas uma por uma ate encontrar "FIM".
 Para cada linha, ele faz quatro verificacoes diferentes:verifica se a linha tem somente vogais, somente consoantes, se e um numero inteiro ou se e um numero real.
 Para fazer isso, o programa percorre cada caractere da String e vai verificando se ele atende a cada condicao. 
 No final, para cada verificacao, mostra "SIM" quando for verdadeirae "NAO" quando for falsa.
 */

public class Is {

    public static boolean ehFim(String lannaTexto) {
        if (lannaTexto.length() != 3) {
            return false;
        }
        return lannaTexto.charAt(0) == 'F' && 
               lannaTexto.charAt(1) == 'I' && 
               lannaTexto.charAt(2) == 'M';
    }

    public static boolean somenteVogais(String lannaTexto) {
        if (lannaTexto.length() == 0) {
            return false;
        }

        for (int i = 0; i < lannaTexto.length(); i++) {
            char lanna = lannaTexto.charAt(i);

            if (lanna != 'a' && lanna != 'e' && lanna != 'i' &&
                lanna != 'o' && lanna != 'u' &&
                lanna != 'A' && lanna != 'E' && lanna != 'I' &&
                lanna != 'O' && lanna != 'U') {
                return false;
            }
        }

        return true;
    }

    public static boolean somenteConsoantes(String lannaTexto) {
        if (lannaTexto.length() == 0) {
            return false;
        }

        for (int i = 0; i < lannaTexto.length(); i++) {
            char lanna = lannaTexto.charAt(i);

            if (!((lanna >= 'a' && lanna <= 'z') ||
                  (lanna >= 'A' && lanna <= 'Z'))) {
                return false;
            }

            if (lanna == 'a' || lanna == 'e' || lanna == 'i' ||
                lanna == 'o' || lanna == 'u' ||
                lanna == 'A' || lanna == 'E' || lanna == 'I' ||
                lanna == 'O' || lanna == 'U') {
                return false;
            }
        }

        return true;
    }

    public static boolean ehInteiro(String lannaTexto) {
        if (lannaTexto.length() == 0) {
            return false;
        }

        for (int i = 0; i < lannaTexto.length(); i++) {
            char lanna = lannaTexto.charAt(i);

            if (lanna < '0' || lanna > '9') {
                return false;
            }
        }

        return true;
    }

    public static boolean ehReal(String lannaTexto) {
        if (lannaTexto.length() == 0) {
            return false;
        }

        int ponto = 0;

        for (int i = 0; i < lannaTexto.length(); i++) {
            char lanna = lannaTexto.charAt(i);

            if (lanna >= '0' && lanna <= '9') {
                continue;
            } else if (lanna == '.' || lanna == ',') {
                ponto++;
                if (ponto > 1) {
                    return false;
                }
            } else {
                return false;
            }
        }

        // Aceita inteiros (ponto == 0) ou decimais (ponto <= 1)
        return ponto <= 1;
    }

    public static void main(String[] args) {
        Scanner leitorzinho = new Scanner(System.in);

        while (leitorzinho.hasNextLine()) {
            String lannaEntrada = leitorzinho.nextLine();

            if (ehFim(lannaEntrada)) {
                break;
            }

            String x1 = somenteVogais(lannaEntrada) ? "SIM" : "NAO";
            String x2 = somenteConsoantes(lannaEntrada) ? "SIM" : "NAO";
            String x3 = ehInteiro(lannaEntrada) ? "SIM" : "NAO";
            String x4 = ehReal(lannaEntrada) ? "SIM" : "NAO";

            System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);
        }

        leitorzinho.close();
    }
}