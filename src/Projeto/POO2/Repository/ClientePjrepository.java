package Projeto.POO2.Repository;

import Projeto.POO2.Domain.ClientePJ;

import java.util.List;

public class ClientePjrepository extends ARepository implements Repository{
    public void create (String cnpj, String nome, int idade){
        ClientePJ clientePJ = new ClientePJ(cnpj,nome,idade);
        add(clientePJ);
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
