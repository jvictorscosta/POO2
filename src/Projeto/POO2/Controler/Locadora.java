package Projeto.POO2.Controler;

public class Locadora {
    public Locadora() {
        System.out.println("Bem vindo(a), a locadora ADA.JAVA");
        showMenu();

    }
    private void showMenu(){
        System.out.println("Por favor, selecione uma das opções abaixo: ");
        System.out.println("1- Cadastrar um Veículo.");
        System.out.println("4- Alterar um Veículo.");
        System.out.println("3- Buscar veículo por modelo.");
        System.out.println("4- Cadastrar um cliente.");
        System.out.println("5- Alterar um cliente.");
        System.out.println("6- Alugar um veículo.");
        System.out.println("7- Devolver um veículo.");
        System.out.println("8- Sair da Locadora.");

    }
}
