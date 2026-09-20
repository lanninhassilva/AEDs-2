/*
Essa classe representa os veiculos que estão no arquivo csv.
Os atributos ficam privados pra não serem acessados diretamentee qualquer lugar. 
Por isso tem os getters, que permitem consultar essas informações quando precisar.

O metodo parseVeiculo recebe uma linha do csv e separa os dados pelas virgulas. 
Depois converte cada informação pro tipo certo, pq no arquivo os valores chegam como texto.

Por exemplo, o id e o ano viram int, o consumo vira doublee o turbo vira boolean. 
Os combustiveis podem ter mais de um valor,então separo eles usando o ponto e virgula.
*/
import java.util.Arrays;

public class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String categoria;
    private String[] combustivel;
    private int cilindros;
    private double cilindrada;
    private String transmissao;
    private String tracao;
    private double consumoCidade;
    private double consumoEstrada;
    private double co2;
    private boolean turbo;
    private Data dataRegistro;

    public Veiculo(
        int id,
        String marca,
        String modelo,
        int ano,
        String categoria,
        String[] combustivel,
        int cilindros,
        double cilindrada,
        String transmissao,
        String tracao,
        double consumoCidade,
        double consumoEstrada,
        double co2,
        boolean turbo,
        Data dataRegistro
    ) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.categoria = categoria;
        this.combustivel = combustivel;
        this.cilindros = cilindros;
        this.cilindrada = cilindrada;
        this.transmissao = transmissao;
        this.tracao = tracao;
        this.consumoCidade = consumoCidade;
        this.consumoEstrada = consumoEstrada;
        this.co2 = co2;
        this.turbo = turbo;
        this.dataRegistro = dataRegistro;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public String[] getCombustivel() {
        return combustivel;
    }

    public int getCilindros() {
        return cilindros;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public String getTracao() {
        return tracao;
    }

    public double getConsumoCidade() {
        return consumoCidade;
    }

    public double getConsumoEstrada() {
        return consumoEstrada;
    }

    public double getCo2() {
        return co2;
    }

    public boolean getTurbo() {
        return turbo;
    }

    public Data getDataRegistro() {
        return dataRegistro;
    }

    public static Veiculo parseVeiculo(String s) {
        String[] p = s.split(",", -1);

        int id = Integer.parseInt(p[0].trim());
        String marca = p[1].trim();
        String modelo = p[2].trim();
        int ano = Integer.parseInt(p[3].trim());
        String categoria = p[4].trim();

        String[] combustivel =
            p[5].trim().split(";");

        int cilindros =
            Integer.parseInt(p[6].trim());

        double cilindrada =
            Double.parseDouble(p[7].trim());

        String transmissao = p[8].trim();
        String tracao = p[9].trim();

        double consumoCidade =
            Double.parseDouble(p[10].trim());

        double consumoEstrada =
            Double.parseDouble(p[11].trim());

        double co2 =
            Double.parseDouble(p[12].trim());

        boolean turbo =
            Boolean.parseBoolean(p[13].trim());

        Data dataRegistro =
            Data.parseData(p[14].trim());

        return new Veiculo(
            id,
            marca,
            modelo,
            ano,
            categoria,
            combustivel,
            cilindros,
            cilindrada,
            transmissao,
            tracao,
            consumoCidade,
            consumoEstrada,
            co2,
            turbo,
            dataRegistro
        );
    }

    public String format() {
        return "[" +
            id + " ## " +
            marca + " ## " +
            modelo + " ## " +
            ano + " ## " +
            categoria + " ## " +
            Arrays.toString(combustivel) + " ## " +
            cilindros + " ## " +
            cilindrada + " ## " +
            transmissao + " ## " +
            tracao + " ## " +
            consumoCidade + " ## " +
            consumoEstrada + " ## " +
            co2 + " ## " +
            turbo + " ## " +
            dataRegistro.format() +
            "]";
    }
}