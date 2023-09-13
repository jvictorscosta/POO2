package Projeto.POO2.Domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDateTime dataSaida;
    private LocalDateTime dataDevolucao;
    private String localAlugado;
    private String lovalRetorno;
    private Boolean aluguelAtivo;
    private final String id;


    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime dataSaida, LocalDateTime dataDevolucao, String localAlugado,String id) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataSaida = dataSaida;
        this.dataDevolucao = dataDevolucao;
        this.localAlugado=localAlugado;
        this.id=id;
    }

    public String getLocalAlugado() {
        return localAlugado;
    }

    public void setLocalAlugado(String localAlugado) {
        this.localAlugado = localAlugado;
    }

    public String getLovalRetorno() {
        return lovalRetorno;
    }

    public void setLovalRetorno(String lovalRetorno) {
        this.lovalRetorno = lovalRetorno;
    }

    public Boolean getAluguelAtivo() {
        return aluguelAtivo;
    }

    public void setAluguelAtivo(Boolean aluguelAtivo) {
        this.aluguelAtivo = aluguelAtivo;
    }

    public String getId() {
        return id;
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

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String toString(){
        return "Resgistro do aluguel: "+id+" -cliente "+cliente.getNome()+" retirou veículo de placa: "+ veiculo.getPlate()+ " dia "+dataSaida +"\n Local: "+localAlugado;
    }
}
