/**
 * Classe que representa uma doação de sangue.
 */
public class Doacao {
    private String codigo;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String tipoSanguineo;
    private int mlsDoados;

    // Construtor
    public Doacao(String codigo, String nome, String cpf, String dataNascimento, String tipoSanguineo, int mlsDoados) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.tipoSanguineo = tipoSanguineo;
        this.mlsDoados = mlsDoados;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public int getMlsDoados() {
        return mlsDoados;
    }

    public void setMlsDoados(int mlsDoados) {
        this.mlsDoados = mlsDoados;
    }

    @Override
    public String toString() {
        return codigo + "," + nome + "," + cpf + "," + dataNascimento + "," + tipoSanguineo + "," + mlsDoados;
    }
}
