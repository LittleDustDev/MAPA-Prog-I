import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Classe para escrita em arquivos CSV.
 */
public class Escritor {

    /**
     * Insere uma nova doação no arquivo CSV.
     * 
     * @param caminhoArquivo Caminho do arquivo CSV.
     * @param novaDoacao Dados da nova doação no formato CSV.
     */
    public static void inserirDoacao(String caminhoArquivo, String novaDoacao) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            bw.newLine();
            bw.write(novaDoacao);
        } catch (IOException e) {
            System.err.println("Erro ao inserir doação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Deleta uma doação do arquivo CSV pelo código da doação.
     * 
     * @param caminhoArquivo Caminho do arquivo CSV.
     * @param codigo Código da doação a ser deletada.
     */
    public static void deletarDoacao(String caminhoArquivo, String codigo) {
        String tempFile = "temp.csv";
        File oldFile = new File(caminhoArquivo);
        File newFile = new File(tempFile);

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String linha;
            boolean encontrou = false;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if (!campos[0].equals(codigo)) {
                    bw.write(linha);
                    bw.newLine();
                } else {
                    encontrou = true;
                }
            }

            if (!encontrou) {
                System.out.println("Código da doação não encontrado.");
            } else {
                // Tentar fechar todos os streams antes de deletar
                br.close();
                bw.close();

                // Garantir que o arquivo antigo seja deletado antes de renomear o novo
                if (oldFile.delete()) {
                    if (newFile.renameTo(oldFile)) {
                        System.out.println("Doação deletada com sucesso.");
                    } else {
                        System.err.println("Erro ao renomear o arquivo temporário.");
                    }
                } else {
                    System.err.println("Erro ao deletar o arquivo original. Pode estar em uso ou sem permissão.");
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao deletar doação: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
