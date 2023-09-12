package Projeto.POO2.Domain;

public class Veiculo {
    private String plate;
    private String type;
    private String model;
    private boolean disponivel;
    private int ano;

    public Veiculo(String plate, String type, String model, int ano) {
        this.plate = plate;
        this.type = type;
        this.model = model;
        this.disponivel = true;
        this.ano = ano;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public String toString(){
        return "Placa: "+plate+" Tipo:"+type+" Modelo: "+ model + " Ano:"+ano+"\n";
    }
}
