import java.util.Scanner;

public class Soma {
	public static int  sominha (int lanna) {
		if (lanna < 10) {
			return lanna;
		}

		//pegao ultimo digito do numero usando o resto da divisao e tira o ultimo numero para continar com os q sobraram, vai fazendo isso até restar somente um.
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
