/*
A lógica do programa é pegar cada caractere do texto e somar 3 ao valor dele na tabela ASCII. Assim, cada letra é trocada pela que está 3 posições depois.

O programa usa um `for` para passar por todos os caracteres, guardar os resultados em um vetor e depois transformar esse vetor em uma `String`.

No `main`, ele fica lendo os textos e mostrando o resultado. Quando o usuário digita `"FIM"`, o programa para.

*/
import java.util.Scanner;

public class Cesar 
{
	public static String cesinha (String str) 
	{
		int const_ = 3; 
		int size = str.length();
		char [] resp = new char [size] ;

		for (int i = 0; i < size; i++ )
		{
			char lanna = (char)(str.charAt(i) + const_);
			resp[i] = lanna; 

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

            String result = cesinha(str); 

            System.out.println(result);
        }

        sc.close();
    }


}
