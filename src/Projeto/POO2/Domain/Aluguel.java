package Projeto.POO2.Domain;

import java.util.Date;

public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private Date dataSaida;
    private Date dataDevolucao;

    public Aluguel(Cliente cliente, Veiculo veiculo, Date dataSaida, Date dataDevolucao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataSaida = dataSaida;
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
