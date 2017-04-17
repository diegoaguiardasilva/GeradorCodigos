package Main;

public class PessoaEntidade {
private String nome;
private String nascimento;
private int idade;
private String cpf;

    public PessoaEntidade() {}

    public PessoaEntidade(String nome,String nascimento,int idade,String cpf) {
    this.nome = nome;
    this.nascimento = nascimento;
    this.idade = idade;
    this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }

    public String getNascimento(){
        return nascimento;
    }

    public int getIdade(){
        return idade;
    }

    public String getCpf(){
        return cpf;
    }
    public void setNome (String nome) {
            this.nome = nome;
    }    public void setNascimento (String nascimento) {
            this.nascimento = nascimento;
    }    public void setIdade (int idade) {
            this.idade = idade;
    }    public void setCpf (String cpf) {
            this.cpf = cpf;
    }

}