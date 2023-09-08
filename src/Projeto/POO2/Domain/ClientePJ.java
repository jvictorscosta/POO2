package Projeto.POO2.Domain;

public class ClientePJ {
    private String cnpj;
    private String nome;
    private int idade;

    public ClientePJ(String cpf, String nome, int idade) {
        this.cnpj = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
