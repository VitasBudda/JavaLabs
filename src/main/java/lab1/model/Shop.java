package lab1.model;

import java.util.HashSet;
import java.util.Set;

public class Shop {

    private String name;
    private Set<Notebook> notebooks;

    public Shop(String name) {
        notebooks = new HashSet<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public boolean addNotebook(Notebook notebook) {
        return notebooks.add(notebook);
    }

    public boolean removeNotebook(Notebook notebook) {
        return notebooks.remove(notebook);
    }

}
