#include <stdio.h>
#include <stdlib.h>

/*
 O programa le duas palavras por linha e verifica se elas sao anagramas. 
 A leitura continua ate encontrar "FIM". Para verificar os anagramas, primeiro compara o tamanho das palavras. 
 Depois, usa um vetor para contar os caracteres da primeira palavrae diminuir os caracteres da segunda. 
 Se todas as contagens forem zero, as palavras sao anagramas. 
*/

char paraMinuscula(char c) {
    if (c >= 'A' && c <= 'Z') {
        return (char)(c + 32);
    }
    return c;
}

int ehFim(char *lannaTexto) {
    int resp = 0;
    if (lannaTexto[0] == 'F' && 
        lannaTexto[1] == 'I' && 
        lannaTexto[2] == 'M' && 
        (lannaTexto[3] == '\0' || lannaTexto[3] == '\n' || lannaTexto[3] == '\r')) {
        resp = 1;
    }
    return resp;
}

void verificaAnagrama(char *lannaLinha) {
    char p1[500];
    char p2[500];
    int i = 0;
    int tam1 = 0;
    int tam2 = 0;

    while (lannaLinha[i] != ' ' && lannaLinha[i] != '\n' && lannaLinha[i] != '\r' && lannaLinha[i] != '\0') {
        p1[tam1] = lannaLinha[i];
        tam1++;
        i++;
    }
    p1[tam1] = '\0';

    while (lannaLinha[i] == ' ') {
        i++;
    }

    while (lannaLinha[i] != '\n' && lannaLinha[i] != '\r' && lannaLinha[i] != '\0') {
        p2[tam2] = lannaLinha[i];
        tam2++;
        i++;
    }
    p2[tam2] = '\0';

    if (tam1 != tam2 || tam1 == 0) {
        printf("NAO\n");
    } else {
        int freq[256];
        for (int k = 0; k < 256; k++) {
            freq[k] = 0;
        }

        for (int k = 0; k < tam1; k++) {
            unsigned char c1 = (unsigned char) paraMinuscula(p1[k]);
            unsigned char c2 = (unsigned char) paraMinuscula(p2[k]);

            freq[c1]++;
            freq[c2]--;
        }

        int ehAnagrama = 1;
        for (int k = 0; k < 256; k++) {
            if (freq[k] != 0) {
                ehAnagrama = 0;
                k = 256;
            }
        }

        if (ehAnagrama == 1) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }
}

int main() {
    char lannaLinha[1000];

    while (fgets(lannaLinha, sizeof(lannaLinha), stdin) != NULL) {
        if (ehFim(lannaLinha)) {
            break;
        }

        verificaAnagrama(lannaLinha);
    }

    return 0;
}