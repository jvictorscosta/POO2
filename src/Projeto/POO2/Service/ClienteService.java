package Projeto.POO2.Service;

import Projeto.POO2.Domain.Cliente;
import Projeto.POO2.Domain.ClientePF;
import Projeto.POO2.Domain.ClientePJ;
import Projeto.POO2.Domain.Veiculo;
import Projeto.POO2.Repository.ClientePfRepository;
import Projeto.POO2.Repository.ClientePjrepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteService implements Service{
    public ClienteService(ClientePfRepository clientePfRepository,ClientePjrepository clientePjrepository){
        this.clientePfRepository= clientePfRepository;
        this.clientePjrepository= clientePjrepository;
    }
    ClientePjrepository clientePjrepository = new ClientePjrepository();
    ClientePfRepository clientePfRepository = new ClientePfRepository();
    public void createPf(String cpf, String nome, int idade){
        clientePfRepository.create(cpf,nome,idade);
    }
    public void createPj(String cnpj, String nome, int idade){
        clientePjrepository.create(cnpj, nome, idade);
    }

    @Override
    public Cliente find(String name) {
        for (Cliente cliente:listAll()) {
                if(cliente.getNome().equalsIgnoreCase(name)){
                    return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listAll() {

        List<Object> objs =new ArrayList<>();
        objs.addAll(clientePfRepository.getAll());
        objs.addAll(clientePjrepository.getAll());
        List<Cliente> clientes= new ArrayList<>();

        for (Object obj : objs) {
            if (obj instanceof Cliente) {
                Cliente cliente = (Cliente) obj; // Faz o cast para Cliente
                clientes.add(cliente);
            }
        }
        return clientes;
    }
    public void updateNome(String nomeCliente,String novoNome){
        find(nomeCliente).setNome(novoNome);
        System.out.println(find(novoNome).toString());
    }
}
