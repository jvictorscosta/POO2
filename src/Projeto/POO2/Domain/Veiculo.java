package Projeto.POO2.Domain;

public class Veiculo {
    private Integer plate;
    private String type;
    private String model;
    private boolean disponivel;
    private int ano;

    public Veiculo(Integer plate, String type, String model, boolean disponivel, int ano) {
        this.plate = plate;
        this.type = type;
        this.model = model;
        this.disponivel = disponivel;
        this.ano = ano;
    }

    public Integer getPlate() {
        return plate;
    }

    public void setPlate(Integer plate) {
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
}
