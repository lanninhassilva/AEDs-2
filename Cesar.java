/*
A lógica do programa é pegar cada caractere do texto e somar 3 ao seu
valor na tabela ASCII. Assim, cada letra é trocada por outra que está
3 posições depois.

O programa faz isso com um for, que passa por todos os caracteres,
guarda os resultados em um vetor e depois transforma esse vetor em
uma String.

No main, ele fica lendo os textos e mostrando o resultado. Quando
o usuário digita "FIM", o programa para.
*/
import java.util.Scanner;

public class Cesar 
{
	public static String cesarCod (String str) 
	{
		int const_ = 3; 
		int size = str.length();
		char [] resp = new char [size] ;

		for (int i = 0; i < size; i++ )
		{
			char oW = (char)(str.charAt(i) + const_);
			resp[i] = oW; 

		}
		

		return new String (resp);	
	}



public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) 
        {
            String str = sc.nextLine();

            if (str.equals("FIM")) {
                break;
            }

            String result = cesarCod(str); 

            System.out.println(result);
        }

        sc.close();
    }


}
