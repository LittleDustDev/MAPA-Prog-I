import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe para leitura de arquivos CSV.
 */
public class Leitor {

    /**
     * Lê e imprime o conteúdo do arquivo CSV.
     * 
     * @param caminhoArquivo Caminho do arquivo CSV.
     */
    public static void lerArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
