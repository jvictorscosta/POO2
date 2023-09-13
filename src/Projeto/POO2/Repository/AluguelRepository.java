package Projeto.POO2.Repository;

import Projeto.POO2.Domain.*;

import java.time.LocalDateTime;
import java.util.Date;


import java.util.List;

public class AluguelRepository extends ARepository implements Repository{

    @Override
    public List<Object> getAll() {
        return list;
    }

    @Override
    public void add(Object entrada) {
        list.add(entrada);

    }

    public Object get(String entrada) {
        for(Object obj : this.list){
            if(obj instanceof Aluguel){
                Aluguel aluguel =(Aluguel) obj;
                if(aluguel.getCliente().equals(entrada)){
                    System.out.println();
                    return obj;
                }
            }
        }
        return null;
    }

    @Override
    public Object find(String entrada) {
        for(Object obj : this.list){
            if(obj instanceof Aluguel){
                Aluguel aluguel =(Aluguel) obj;
                if(entrada.equals(String.valueOf(aluguel.getId()))){

                    return aluguel;
                }
            }
        }

        return null;
    }
    public Aluguel create(Cliente cliente, Veiculo veiculo, LocalDateTime dataSaida, LocalDateTime dataDevolucao,String localAlugado, int counter) {
        Aluguel aluguel = new Aluguel(cliente, veiculo, dataSaida, dataDevolucao,localAlugado, String.valueOf(counter));
        add(aluguel);
        return aluguel;
    }
}
