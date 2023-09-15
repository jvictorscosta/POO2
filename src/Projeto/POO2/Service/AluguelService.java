package Projeto.POO2.Service;

import Projeto.POO2.Domain.*;
import Projeto.POO2.Repository.AluguelRepository;

import java.time.LocalDateTime;

import java.util.List;

public class AluguelService implements Service{
    private static int COUNTER_ALUGUEL;
    AluguelRepository aluguelRepository;
   public AluguelService( AluguelRepository aluguelRepository){
       this.aluguelRepository=aluguelRepository;
   }
    @Override
    public Aluguel find(String id) {
        return (Aluguel) aluguelRepository.find(id);
    }


    @Override
    public List listAll() {
        return aluguelRepository.getAll();
    }
    public Aluguel createAluguel(Cliente cliente, Veiculo veiculo, LocalDateTime dataSaida, LocalDateTime dataDevolucao,String localAlugado ){
        return aluguelRepository.create(cliente,veiculo,dataSaida,dataDevolucao,localAlugado,++AluguelService.COUNTER_ALUGUEL);
    }
    public double calcularDesconto(String idAluguel){
       if (find(idAluguel).getCliente() instanceof ClientePJ && diasAlugados(idAluguel)>3){
           System.out.println("10%");//apagar
           return 0.10;//10%
       }else if(find(idAluguel).getCliente() instanceof ClientePF && diasAlugados(idAluguel)>5){
            System.out.println("5%");//apagar
            return 0.05;//5%
       }
        System.out.println("0%");//apagar
       return 0;

    }

    public int diasAlugados(String idAluguel){
           return find(idAluguel).getDataDevolucao().compareTo(find(idAluguel).getDataSaida());
    }
    public double definirTaxaDiaria(String idAluguel){
       String tipoVeiculo =find(idAluguel).getVeiculo().getType();
       double valorDaDiaria=0;
       if("PEQUENO".equals(tipoVeiculo)){
           valorDaDiaria=100.00;
       }else if("MÉDIO".equals(tipoVeiculo)){
           valorDaDiaria=150.00;
       }else if("SUV".equals(tipoVeiculo)){
           valorDaDiaria=200.00;
       }

       return valorDaDiaria;
    }
    public double calcularValorDiaria(String idAluguel){
       return diasAlugados(idAluguel)*definirTaxaDiaria(idAluguel);
    }
    public double calcularValorDesconto(String idAluguel){
       return calcularValorDiaria(idAluguel)*calcularValorDiaria(idAluguel);
    }
    public double valorTotal(String idAluguel){


        double valorFinal=  calcularValorDiaria(idAluguel)-calcularValorDesconto(idAluguel);

        System.out.println(valorFinal);
        return valorFinal;
    }

}
