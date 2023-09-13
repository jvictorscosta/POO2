package Projeto.POO2.Service;

import Projeto.POO2.Domain.Aluguel;
import Projeto.POO2.Domain.Cliente;
import Projeto.POO2.Domain.Veiculo;
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
}
