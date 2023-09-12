package Projeto.POO2.Controler;

import Projeto.POO2.Repository.ClientePfRepository;
import Projeto.POO2.Repository.ClientePjrepository;
import Projeto.POO2.Repository.VeiculoRepository;
import Projeto.POO2.Service.ClienteService;
import Projeto.POO2.Service.VeiculoService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Locadora {
    Scanner scanner = new Scanner(System.in);
    VeiculoRepository veiculoRepository=new VeiculoRepository();
    ClientePjrepository clientePjrepository=new ClientePjrepository();
    ClientePfRepository clientePfRepository=new ClientePfRepository();
    VeiculoService veiculoService = new VeiculoService(veiculoRepository);
    ClienteService clienteService = new ClienteService(clientePfRepository,clientePjrepository);

    public void execute() {
        //TESTE
        clienteService.createPj("0772323","joao",12);
        clienteService.createPf("123123","Maria",15);
        clienteService.createPf("321321","Fernando",23);
        veiculoService.create("Pudim","SUV","Fiat uno",1999);
        veiculoService.create("PudimPodre","PEQUENO","Fiat Sandero",1979);
        veiculoService.create("PuDPASm","SUV","Fiat uno",1991);
        veiculoService.create("asd","SUV","Gol",1994);
        //teste-fim

        System.out.println("Bem vindo(a), a locadora ADA.JAVA");
        boolean sair=false;
        do {
                int option = showMenu();
                if (option == 8){sair = true;                }
                menuChoice(option);
            }while(sair==false);
        }


    private int showMenu(){
        System.out.println();
        System.out.println("---Por favor, selecione uma das opções abaixo: ");
        System.out.println("1- Cadastrar um Veículo.");
        System.out.println("2- Alterar um Veículo.");
        System.out.println("3- Buscar veículo por modelo.");
        System.out.println("4- Cadastrar um cliente.");
        System.out.println("5- Alterar um cliente.");
        System.out.println("6- Alugar um veículo.");
        System.out.println("7- Devolver um veículo.");
        System.out.println("8- Sair da Locadora.");
        System.out.print  ("   Digite o número correspondente a opção desejada: ");
        System.out.println();
        int option = scanner.nextInt();
        return option;
    }
    private void menuChoice(int option){
        switch (option){
            case 1 -> {
                cadastrarVeiculo();
            }
            case 2 -> {
                alterarVeiculo();
            }
            case 3 -> {
                buscarVeiculoModelo();
            }
            case 4->{
                cadastrarCliente();
            }
            case 5 -> {
                alterarCliente();
            }
            case 6 -> {
                alugarVeiculo();
            }
            case 7 -> {
                devolverVeiculo();
            }
            case 8 ->{
                System.out.println("Obrigado e volte sempre!");
            }
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    private void buscarVeiculoModelo() {
        scanner.nextLine();
        System.out.print("Favor fornecer modelo do veiculo procurado:");
        String modeloProcurado= scanner.nextLine();
        System.out.println(veiculoService.findModelo(modeloProcurado).toString());

    }


    private void devolverVeiculo() {
    }

    private void alugarVeiculo() {

    }

    private void alterarCliente() {
        scanner.nextLine();
        System.out.println(clienteService.listAll().toString());
        System.out.println("Favor fornecer nome do cliente a ser alterado: ");
        String inputNomeCliente = scanner.nextLine();

        System.out.println("Qual novo nome para esse Cliente?");
        String nomeAlterado= scanner.nextLine();

        System.out.println();
        if(clienteService.find(inputNomeCliente)==null){
            System.out.println("Nenhum cliente com este nome foi encontrado.");
        }else {
            clienteService.updateNome(inputNomeCliente,nomeAlterado);
        }
    }

    private void alterarVeiculo() {
        scanner.nextLine();
        System.out.println("Favor fornecer Placa do veiculo a ser alterado: ");
        String inputPlaca = scanner.nextLine();
        System.out.println(veiculoService.find(inputPlaca).toString());
        veiculoService.listAll();
    }

    private void cadastrarVeiculo(){
        scanner.nextLine();
        System.out.println();
        System.out.println("-CADASTRANDO VEICULO.");
        System.out.println("Qual placa do veiculo deseja cadastrar?");
        String plate = scanner.nextLine();
        System.out.println("Qual o tipo do veiculo a ser cadastrado? 1-PEQUENO, 2-MÉDIO ou 3-SUV?");
        System.out.println("Digite o número.");
        int option = scanner.nextInt();
        String type;
        switch (option){
            case 1->{
               type="PEQUENO";
            }
            case 2->{
                type="MÉDIO";
            }
            case 3->{
                type="SUV";
            }
            default -> {
                throw new RuntimeException("Opção invalida.");
            }
        }
        System.out.println("Qual modelo do veiculo?");
        String model = scanner.nextLine();
        System.out.println("Qual ano foi fabricado o veiculo");
        int ano= scanner.nextInt();
        veiculoService.create(plate,type,model,ano);

    }
    private void cadastrarCliente(){
        int option;
        do {
        scanner.nextLine();
        System.out.println("digite 1 para cadastar um Cliente como pessoa jurica ou 2 para cadastrar como pessoa fisica?");
        option = scanner.nextInt();
            if(option==1){

                scanner.nextLine();
                System.out.println("cadastrando cliente pessoa juridica.");
                System.out.println();
                System.out.println("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.println("Digite o CNPJ do cliente: ");
                String cnpj = scanner.nextLine();
                System.out.println("Digite a idade do cliente: ");
                int idade = scanner.nextInt();
                clienteService.createPj(cnpj,nome,idade);
                System.out.println("CLIENTE CADASTRADO COM SUCESSO");
            }else if(option ==2){
                scanner.nextLine();
                System.out.println("cadastrando cliente pessoa fisica.");
                System.out.println();
                System.out.println("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.println("Digite o cpf do cliente: ");
                String cpf = scanner.nextLine();
                System.out.println("Digite a idade do cliente: ");
                int idade = scanner.nextInt();
                clienteService.createPf(cpf,nome,idade);
                System.out.println("CLIENTE CADASTRADO COM SUCESSO");
            }else if(option!=1&&option!=2 ){
                System.out.println("Opção invalida");
            }

        }while (option!=1&&option!=2);

    }
}
