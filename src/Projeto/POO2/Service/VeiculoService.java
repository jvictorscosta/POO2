package Projeto.POO2.Service;

import Projeto.POO2.Domain.Veiculo;
import Projeto.POO2.Repository.VeiculoRepository;

import java.util.List;

public class VeiculoService implements Service{
    VeiculoRepository  veiculoRepository;
    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository=veiculoRepository;
    }


    public void create(String plate, String type, String model, int ano) {
        veiculoRepository.create(plate,type,model,ano);
    }

    @Override
    public Object find(String name) {
        return veiculoRepository.find(name);

    }
    public Object findModelo(String name) {
        return veiculoRepository.findModelo(name);

    }
    public void print(){
        System.out.println(veiculoRepository.getAll().toString());
    }

    @Override
    public List listAll() {
        return veiculoRepository.getAll();
    }

    public void alternarDisp(Veiculo veiculo) {
        veiculoRepository.alternarDisp(veiculo);
    }
}
