/*
 O programa recebe um numero e faz a soma de todos os algarismos dele.
 O metodo usa a recursao para ir pegando cada numero.
 Ele usa o resto da divisao por 10 para pegar o ultimo algarismoe depois divide por 10 para tirar esse algarismo e continuar com o restante do numero. Quando sobra so um algarismo, ele retorna.
 */

import java.util.Scanner;

public class Soma {
	public static int  sominha (int lanna) {
		if (lanna < 10) {
			return lanna;
		}
		return (lanna % 10) + sominha(lanna / 10);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int lanna = sc.nextInt();
        
			System.out.println(sominha(lanna));

		sc.close();
	}
}
