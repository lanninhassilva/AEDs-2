
#include <stdio.h>
#include <stdlib.h>

/*
 O programa le linhas da entrada padrao ate encontrar "FIM".
 Para cada linha, calcula o tamanho da maior substring sem caracteres repetidos.
 Para isso, guarda a ultima posicao em que cada caractere apareceu.
 Quando um caractere se repete dentro da parte atual, o inicio e movidopara depois da ultima ocorrencia desse caractere.
 */

int tamanhoString(char *lannaTexto) {
    int tam = 0;

    while (lannaTexto[tam] != '\0' &&
           lannaTexto[tam] != '\n' &&
           lannaTexto[tam] != '\r') {
        tam++;
    }

    lannaTexto[tam] = '\0';

    return tam;
}

int ehFim(char *lannaTexto) {
    int resp = 0;

    if (lannaTexto[0] == 'F' &&
        lannaTexto[1] == 'I' &&
        lannaTexto[2] == 'M' &&
        lannaTexto[3] == '\0') {
        resp = 1;
    }

    return resp;
}

int maiorSubstringSemRepeticao(char *lannaTexto) {
    int tam = tamanhoString(lannaTexto);
    int maior = 0;
    int inicio = 0;
    int ultimaPosicao[256];
    int i;

    for (i = 0; i < 256; i++) {
        ultimaPosicao[i] = -1;
    }

    for (i = 0; i < tam; i++) {
        int c = lannaTexto[i];

        if (ultimaPosicao[c] >= inicio) {
            inicio = ultimaPosicao[c] + 1;
        }
        ultimaPosicao[c] = i;
        int atual = i - inicio + 1;

        if (atual > maior) {
            maior = atual;
        }
    }

    return maior;
}

int main() {
    char lannaLinha[1000];
    int resultado;

    while (fgets(lannaLinha, sizeof(lannaLinha), stdin) != NULL) {

        tamanhoString(lannaLinha);

        if (ehFim(lannaLinha)) {
            break;
        }

        resultado = maiorSubstringSemRepeticao(lannaLinha);

        printf("%d\n", resultado);
    }

    return 0;
}