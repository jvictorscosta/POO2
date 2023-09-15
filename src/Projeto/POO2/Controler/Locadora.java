package Projeto.POO2.Controler;

import Projeto.POO2.Domain.Cliente;
import Projeto.POO2.Domain.Veiculo;
import Projeto.POO2.Repository.*;
import Projeto.POO2.Service.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Locadora {
    Scanner scanner = new Scanner(System.in);
    VeiculoRepository veiculoRepository=new VeiculoRepository();
    ClientePjrepository clientePjrepository=new ClientePjrepository();
    ClientePfRepository clientePfRepository=new ClientePfRepository();
    VeiculoService veiculoService = new VeiculoService(veiculoRepository);
    ClienteService clienteService = new ClienteService(clientePfRepository,clientePjrepository);
    AluguelRepository aluguelRepository=new AluguelRepository();
    AluguelService aluguelService=new AluguelService(aluguelRepository);

    public void execute() {

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
        scanner.nextLine();
        System.out.println();
        System.out.println("RETORNANDO VEICULO");
        System.out.println("Digite qual id do alguel para retorno do veiculo.");
        String idDevolvendo= scanner.nextLine();
        System.out.println("Qual a cidade do retorno?");
        scanner.nextLine();
        String localRetorno= scanner.nextLine();
        aluguelService.find(idDevolvendo).setLovalRetorno(localRetorno);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        boolean isParsingSuccess = false;
        LocalDateTime dataRetorno = null;

        while (!isParsingSuccess) {
            try {
                System.out.println("Digite a data e hora de devolução do veiculo no formato dd/mm/aaaa HH:mm:");
                String dataEntrada = this.scanner.nextLine();
                dataRetorno = LocalDateTime.parse(dataEntrada, formatter);
                isParsingSuccess = true;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. O formato aceito é dd/mm/aaaa hh:mm, por exemplo 15/05/1997 12:00.");
            }
        }
        aluguelService.find(idDevolvendo).setDataDevolucao(dataRetorno);
        System.out.println("Veiculo ficou alugado por "+aluguelService.diasAlugados(idDevolvendo) + " dias");
        System.out.printf("Valor total do aluguel é de %.2f",aluguelService.valorTotal(idDevolvendo));
        veiculoService.alternarDisp(aluguelService.find(idDevolvendo).getVeiculo());
    }
    private void alugarVeiculo() {
        scanner.nextLine();
        System.out.println("ALUGANDO VEICULO");
        System.out.println("Qual cliente está alugando veiculo?");
        String clienteProcurado= scanner.nextLine();
        Cliente cliente = clienteService.find(clienteProcurado);
        System.out.println("Qual modelo de veiculo está procurando");
        String tipo=escolherTipo();
        System.out.println("Qual dos modelos abaixo está procurando? ");
        System.out.println(veiculoService.findModelo(tipo).toString());
        scanner.nextLine();
        System.out.println("Digite a placa do veiculo escolhido:");
        String placaEscolhida=scanner.nextLine();
        Veiculo veiculo = (Veiculo) veiculoService.find(placaEscolhida);
        veiculoService.alternarDisp(veiculo);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        boolean isParsingSuccess = false;
        LocalDateTime dataRetirada = null;
        while (!isParsingSuccess) {
            try {
                System.out.println("Digite a data de retirada do veiculo no formato dd/mm/aaaa HH:mm:");
                String dataEntrada = this.scanner.nextLine();
                dataRetirada = LocalDateTime.parse(dataEntrada, formatter);
                isParsingSuccess = true;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. O formato aceito é dd/mm/aaaa hh:mm, por exemplo 15/05/1997 12:00.");
            }
        }
        System.out.println("Por quantos dias pretende ficar com o veiculo?");
        int diasPretendidos=scanner.nextInt();
        LocalDateTime dataDevolucaoPretendida=dataRetirada.plusDays(diasPretendidos);
        System.out.println("Retirada será no dia "+dataDevolucaoPretendida.format(formatter));
        scanner.nextLine();
        System.out.println("De qual Cidade o local está sendo Alugado? ");
        String localAlugado=scanner.nextLine();
        System.out.println(aluguelService.createAluguel(cliente,veiculo,dataRetirada,dataDevolucaoPretendida,localAlugado).toString());
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
        System.out.println();
        System.out.println("ALTERANDO VEICULO");
        System.out.println("Listando todos os veiculos");
        System.out.println(veiculoService.listAll());
        System.out.println("Favor fornecer Placa do veiculo a ser alterado: ");
        String inputPlaca = scanner.nextLine();
        System.out.println(veiculoService.find(inputPlaca).toString());
        veiculoService.listAll();

    }

    private void cadastrarVeiculo(){
        scanner.nextLine();
        System.out.println();
        System.out.println("-CADASTRANDO VEICULO.");
        boolean placaIgual=false;
        System.out.println("Qual placa do veiculo deseja cadastrar?");
        String plate="PLACA VAZIA";
        while(!placaIgual ) {
            plate = scanner.nextLine();
            if(veiculoService.find(plate)==null){
                placaIgual=true;
            }else{
                System.out.println("Placa repetida, tente outra:");
            }
        }
        System.out.println("Qual o tipo do veiculo a ser cadastrado? ");
        String type=escolherTipo();
        scanner.nextLine();
        System.out.println("Qual modelo do veiculo?");
        String model = scanner.nextLine();
        boolean isParsingSuccess = false;
        int ano=0;
        while (!isParsingSuccess) {
            try {
                System.out.println("Qual ano foi fabricado o veiculo");
                ano= scanner.nextInt();
                isParsingSuccess = true;
            } catch (Exception e) {
                System.out.println("Data inválida. favor digitar um inteiro.");
            }
        }
        System.out.println("Qual ano foi fabricado o veiculo");
        veiculoService.create(plate,type,model,ano);

    }

    private String escolherTipo(){

        System.out.println("Digite o número para um modelo.");
        System.out.println("1-PEQUENO, 2-MÉDIO ou 3-SUV?");
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
        return type;
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
                String nome = "NOME VAZIO";
                boolean nomeIgual = false;
                while(!nomeIgual ) {
                    nome = scanner.nextLine();
                    if(clienteService.find(nome)==null){
                        nomeIgual=true;
                    }else{
                        System.out.println("Nome já cadastrado, tente outro:");
                    }
                }
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
                String nome = "NOME VAZIO";
                boolean nomeIgual = false;
                while(!nomeIgual ) {
                    nome = scanner.nextLine();
                    if(clienteService.find(nome)==null){
                        nomeIgual=true;
                    }else{
                        System.out.println("Nome já cadastrado, tente outro:");
                    }
                }
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
