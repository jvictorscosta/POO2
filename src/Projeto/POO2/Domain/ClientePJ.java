package Projeto.POO2.Domain;

public class ClientePJ extends Cliente {
    private String cnpj;
    private String nome;
    private int idade;

    public ClientePJ(String cnpj, String nome, int idade) {
        super(nome);
        this.cnpj = cnpj;
        this.idade = idade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }



}
