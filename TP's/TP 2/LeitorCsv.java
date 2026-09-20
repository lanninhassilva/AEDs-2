/*
Essa classe é responsavel por fazer a leitura do arquivo csve transformar as informações que estão nele em objetos Veiculo.

Primeiro o programa abre o arquivo e pega todas as linhas.
A primeira linha é o cabeçalho, que tem o nome das colunas,então ela não precisa ser transformada em um veiculo.

Depois percorro as outras linhas usando um for.
Cada linha é enviada pro metodo parseVeiculo, que separae converte os dados, criando um objeto Veiculo.

Vou guardando os veiculos em uma lista, porque assim consigo adicionar cada novo veiculo conforme o arquivo é lido.
No final transformo essa lista em um vetor de Veiculo e retorno ele pra ser usado no programa principal.
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LeitorCsv {

    public static Veiculo[] ler(String caminhoArquivo) {
        List<Veiculo> lista = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(
                Paths.get(caminhoArquivo),
                StandardCharsets.UTF_8
            );

            // Ignora o cabeçalho do CSV.
            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);

                if (!linha.trim().isEmpty()) {
                    Veiculo v =
                        Veiculo.parseVeiculo(linha);

                    lista.add(v);
                }
            }

        } catch (IOException e) {
            System.err.println(
                "Erro ao ler o arquivo: " + caminhoArquivo
            );
        }

        return lista.toArray(new Veiculo[0]);
    }
}