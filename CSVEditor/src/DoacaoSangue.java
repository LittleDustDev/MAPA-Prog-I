import java.util.Scanner;

/**
 * Classe principal para interação com o usuário.
 */
public class DoacaoSangue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o caminho do arquivo CSV:");
        String caminhoArquivo = scanner.nextLine();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ler arquivo");
            System.out.println("2. Inserir nova doação");
            System.out.println("3. Deletar doação");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Leitor.lerArquivo(caminhoArquivo);
                    break;
                case 2:
                    System.out.println("Informe a nova doação no formato (código,nome,cpf,data_nascimento,tipo_sanguíneo,mls_doados):");
                    String novaDoacao = scanner.nextLine();
                    Escritor.inserirDoacao(caminhoArquivo, novaDoacao);
                    break;
                case 3:
                    System.out.println("Informe o código da doação a ser deletada:");
                    String codigo = scanner.nextLine();
                    Escritor.deletarDoacao(caminhoArquivo, codigo);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
