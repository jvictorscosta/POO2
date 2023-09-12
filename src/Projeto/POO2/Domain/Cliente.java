package Projeto.POO2.Domain;

public class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }

    @Override
    public String toString() {
        return "Nome:"+nome+"\nIdade: "+idade;
    }
}
