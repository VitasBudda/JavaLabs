package lab2.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Shop implements Serializable {

    private String name;
    private Set<Notebook> notebooks;

    public Shop() {
        notebooks = new HashSet<>();
    }

    public Shop(String name) {
        this.name = name;
        notebooks = new HashSet<>();
    }

    public Shop(String name, Set<Notebook> notebooks) {
        this.name = name;
        this.notebooks = notebooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;
        if (!Objects.equals(name, shop.name)) return false;
        return Objects.equals(notebooks, shop.notebooks);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (notebooks != null ? notebooks.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

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
