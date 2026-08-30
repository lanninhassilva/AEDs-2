#include <stdio.h>

/*
 * O programa pega cada caractere da frase e aumenta 3 no seu valorda tabela ASCII. 
 A funcao vai fazendo isso de forma recursiva,passando por cada posicao do texto ate chegar ao final.
 Quando chega no fim, ela para. No main, o programa continua lendo as frases e mostrando cada uma ja cifrada. 
 Quando aparece "FIM", a leitura termina.
 */

void cesinha(char str[], int i) {
    if (str[i] == '\0') {
        return;
    }

    str[i] = str[i] + 3;

    cesinha(str, i + 1);
}

int main() {
    char lanna[1000];

    while (fgets(lanna, 1000, stdin) != NULL) {

        if (lanna[0] == 'F' &&
            lanna[1] == 'I' &&
            lanna[2] == 'M' &&
            lanna[3] == '\n') {
            break;
        }

        cesinha(lanna, 0);

        printf("%s", lanna);
    }

    return 0;
}