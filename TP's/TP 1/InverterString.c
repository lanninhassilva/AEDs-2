#include <stdio.h>
#include <stdlib.h>

/*
O programa le varias linhas ate encontrar "FIM".
Para cada linha, a funcao vai percorrendo os caracteres de tras para frentee mostrando eles na ordem invertida. A inversao e feita de forma iterativa, usando um for para comecar no ultimo caractere e ir ate o primeiro.
No final de cada linha, o resultado e mostrado na tela.
*/

int tamanhoString(char *lannaTexto) {
    int tam = 0;
    while (lannaTexto[tam] != '\0' && lannaTexto[tam] != '\n' && lannaTexto[tam] != '\r') {
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

void inverteString(char *lannaTexto) {
    int tam = tamanhoString(lannaTexto);

    for (int i = tam - 1; i >= 0; i--) {
        printf("%c", lannaTexto[i]);
    }
    printf("\n");
}

int main(void) {
    char lannaPalavra[500];

    while (fgets(lannaPalavra, sizeof(lannaPalavra), stdin) != NULL) {
        tamanhoString(lannaPalavra);

        if (ehFim(lannaPalavra)) {
            break;
        }

        inverteString(lannaPalavra);
    }

    return 0;
}