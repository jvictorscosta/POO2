package Projeto.POO2.Repository;

import Projeto.POO2.Domain.*;

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
        return null;
    }
    public void create(Cliente cliente, Veiculo veiculo, Date dataSaida, Date dataDevolucao) {
        Aluguel aluguel = new Aluguel(cliente, veiculo, dataSaida, dataDevolucao);
        add(aluguel);
    }
}
