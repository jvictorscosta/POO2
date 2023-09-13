package Projeto.POO2.Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class ARepository {
    public List<Object> list;

    public ARepository() {
        this.list = new ArrayList<>();
    }

    public abstract void add(Object entrada);


    public abstract List<Object> getAll();

}