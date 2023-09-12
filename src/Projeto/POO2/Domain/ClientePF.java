package Projeto.POO2.Domain;

public class ClientePF extends Cliente {
    private String cpf;
    private String nome;
    private int idade;

    public ClientePF(String cpf, String nome, int idade) {
        super(nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String toString(){
        return super.toString()+"CPF: "+cpf;
    }
}
