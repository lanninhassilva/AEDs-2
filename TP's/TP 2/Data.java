/*
Essa classe serve pra trabalhar com as datas dos veiculos.
Como a data vem do arquivo em formato de texto, preciso separar ela em dia, mes e ano pra conseguir guardar essas informações.
No metodo parseData eu separo a data usando o hifen e depois transformo cada parte de String pra int, pq no começo tudo é texto.
Com esses valores eu crio um novo objeto Data e retorno ele.

Os getters servem pra acessar os valores que estão privados.
Já o format organiza a data no formato dia/mes/ano, colocando zero na frente quando o dia ou o mes tem só um digito.
*/

public class Data {
    private int ano;
    private int mes;
    private int dia;

    public Data(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public static Data parseData(String s) {
        String[] partes = s.split("-");

        int ano = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);

        return new Data(ano, mes, dia);
    }

    public String format() {
        return String.format(
            "%02d/%02d/%04d",
            dia, mes, ano
        );
    }
}
