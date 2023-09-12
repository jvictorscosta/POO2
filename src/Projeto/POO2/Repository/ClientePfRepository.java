package Projeto.POO2.Repository;

import Projeto.POO2.Domain.ClientePF;

import java.util.List;

public class ClientePfRepository extends ARepository implements Repository {
    public void create(String cpf, String nome, int idade){
        ClientePF clientePF = new ClientePF(cpf,nome,idade);
        add(clientePF);
    }
    @Override
    public List<Object> getAll() {

        return list;
    }

    @Override
    public void add(Object entrada) {
        this.list.add(entrada);
    }

    @Override
    public Object get(String index) {
        return null;
    }

    @Override
    public Object find(String entrada) {
        return null;
    }
}
