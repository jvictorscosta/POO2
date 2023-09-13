package Projeto.POO2.Repository;

import Projeto.POO2.Domain.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository extends ARepository implements Repository{



    @Override
    public List<Object> getAll() {
        return this.list;
    }


    @Override
    public void add(Object entrada) {
        list.add(entrada);
    }

    public Object get(String entrada) {
        for(Object obj : this.list){
            if(obj instanceof Veiculo){
                Veiculo veiculo =(Veiculo) obj;
                if(veiculo.getPlate().equals(entrada)){
                    System.out.println();
                    return obj;
                }
            }
        }
        return null;
    }

    @Override
    public List<Veiculo> find(String entradaPlaca) {
        List<Veiculo> veiculosEncontrados = new ArrayList<>();
        for(Object obj : this.list){
            if(obj instanceof Veiculo){
                Veiculo veiculo =(Veiculo) obj;
                if(veiculo.getPlate().equalsIgnoreCase(entradaPlaca)){
                    veiculosEncontrados.add((Veiculo) obj);
                }
            }
        }
        return veiculosEncontrados;
    }
    public List<Veiculo> findModelo(String entradaTypo) {
        List<Veiculo> veiculosEncontrados = new ArrayList<>();
        for(Object obj : this.list){
            if(obj instanceof Veiculo){
                Veiculo veiculo =(Veiculo) obj;
                if(veiculo.getType().contains(entradaTypo)){
                    veiculosEncontrados.add((Veiculo) obj);
                }
            }
        }
        return veiculosEncontrados;
    }
    public void create(String plate, String type, String model, int ano){
        Veiculo veiculo = new Veiculo(plate,type,model,ano);
        add(veiculo);
    }
    public Veiculo buscar(String plate){

        return null;
    }
}
