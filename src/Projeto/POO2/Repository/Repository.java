package Projeto.POO2.Repository;

import java.util.List;

public interface Repository {
    public List<Object> getAll();
    public void add(Object entrada);
    public Object find(String entrada);


}
