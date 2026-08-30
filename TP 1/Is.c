#include <stdio.h>

/*
 * O programa vai lendo as linhas ate encontrar "FIM".
 * Para cada linha, sao feitas quatro verificacoes: se tem somente
 * vogais, somente consoantes, se e um numero inteiro ou se e um
 * numero real.
 *
 * As verificacoes sao feitas de forma recursiva. A funcao vai
 * olhando um caractere por vez e passando para a proxima posicao.
 * Quando chega no final da string, ela termina a verificacao.
 * No final, cada resultado e mostrado como "SIM" ou "NAO".
 */

int ehVogal(char lanna) {
    return lanna == 'a' || lanna == 'e' || lanna == 'i' ||
           lanna == 'o' || lanna == 'u' ||
           lanna == 'A' || lanna == 'E' || lanna == 'I' ||
           lanna == 'O' || lanna == 'U';
}

int somenteVogais(char lanna[], int i) {
    int resposta;

    if (lanna[i] == '\0') {
        resposta = (i > 0);
    } else if (!ehVogal(lanna[i])) {
        resposta = 0;
    } else {
        resposta = somenteVogais(lanna, i + 1);
    }

    return resposta;
}

int somenteConsoantes(char lanna[], int i) {
    int resposta;
    char atual = lanna[i];

    if (atual == '\0') {
        resposta = (i > 0);
    } else if (!((atual >= 'a' && atual <= 'z') ||
                 (atual >= 'A' && atual <= 'Z'))) {
        resposta = 0;
    } else if (ehVogal(atual)) {
        resposta = 0;
    } else {
        resposta = somenteConsoantes(lanna, i + 1);
    }

    return resposta;
}

int ehInteiro(char lanna[], int i) {
    int resposta;

    if (lanna[i] == '\0') {
        resposta = (i > 0);
    } else if (lanna[i] < '0' || lanna[i] > '9') {
        resposta = 0;
    } else {
        resposta = ehInteiro(lanna, i + 1);
    }

    return resposta;
}

int ehReal(char lanna[], int i, int ponto) {
    int resposta;
    char atual = lanna[i];

    if (atual == '\0') {
        resposta = 1;
    } else if (atual >= '0' && atual <= '9') {
        resposta = ehReal(lanna, i + 1, ponto);
    } else if (atual == '.' || atual == ',') {
        if (ponto == 1) {
            resposta = 0;
        } else {
            resposta = ehReal(lanna, i + 1, 1);
        }
    } else {
        resposta = 0;
    }

    return resposta;
}

int main() {
    char lanna[1000];

    while (fgets(lanna, 1000, stdin) != NULL) {

        int tamanho = 0;

        while (lanna[tamanho] != '\0') {
            if (lanna[tamanho] == '\n') {
                lanna[tamanho] = '\0';
            } else {
                tamanho++;
            }
        }

        if (lanna[0] == 'F' &&
            lanna[1] == 'I' &&
            lanna[2] == 'M' &&
            lanna[3] == '\0') {
            break;
        }

        int x1 = somenteVogais(lanna, 0);
        int x2 = somenteConsoantes(lanna, 0);
        int x3 = ehInteiro(lanna, 0);
        int x4 = ehReal(lanna, 0, 0);

        printf("%s %s %s %s\n",
               x1 ? "SIM" : "NAO",
               x2 ? "SIM" : "NAO",
               x3 ? "SIM" : "NAO",
               x4 ? "SIM" : "NAO");
    }

    return 0;
}