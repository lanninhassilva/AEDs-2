#include <stdio.h>

/*
 Aqui o programa recebe varios numeros e calcula a soma dos seusalgarismos. 
 A funcao sominha vai separando os numeros aos poucos:
com % 10 ela pega o algarismo que esta no final e com / 10 ele desaparece da proxima chamada. 
Assim a funcao vai fazendo as somas ate chegar no primeiro algarismo. No main, isso e feito para todosos numeros que forem lidos na entrada.
 */
 

int sominha(int lanna) {
    if (lanna < 10) {
        return lanna;
    }

    return (lanna % 10) + sominha(lanna / 10);
}

int main() {
    int lanna;

    while (scanf("%d", &lanna) != EOF) {
        printf("%d\n", sominha(lanna));
    }

    return 0;
}