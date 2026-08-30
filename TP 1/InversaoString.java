import java.util.Scanner;

public class InversaoString {

    // Inverte a string c recursao
    public static String Inverter(String s, int i){

        // Quando chegar no final, para a recursao
        if(i >= s.length()){
            return "";
        }

        // Vai ate o final e dps faz a string ao contrario
        return Inverter(s, i + 1) + s.charAt(i);
    }

    // Ve se a entrada é FIM
    public static boolean Fim(String s){

        int resp = 0;

        if(s.length() == 3){
            if(s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
                resp = 1;
            }
        }

        return resp == 1;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine();

        // Continua lendo ate aparecer FIM
        while(Fim(entrada) == false){

            String resp = Inverter(entrada, 0);

            System.out.println(resp);

            // Le a proxima linha
            entrada = sc.nextLine();
        }

        sc.close();
    }
}