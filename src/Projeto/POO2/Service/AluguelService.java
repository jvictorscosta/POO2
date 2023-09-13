package Projeto.POO2.Service;

import Projeto.POO2.Domain.Aluguel;
import Projeto.POO2.Domain.Cliente;
import Projeto.POO2.Domain.Veiculo;
import Projeto.POO2.Repository.AluguelRepository;

import java.util.Date;
import java.util.List;

public class AluguelService implements Service{
    AluguelRepository aluguelRepository;
   public AluguelService( AluguelRepository aluguelRepository){
       this.aluguelRepository=aluguelRepository;
   }
    @Override
    public Object find(String name) {

        return null;
    }

    @Override
    public List listAll() {
        return null;
    }
    public void createAluguel(Cliente cliente, Veiculo veiculo, Date dataSaida, Date dataDevolucao){
        aluguelRepository.create(cliente,veiculo,dataSaida,dataDevolucao);
    }
}
