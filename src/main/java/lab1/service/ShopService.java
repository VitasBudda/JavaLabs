package lab1.service;

import lab1.model.Notebook;
import lab1.model.Shop;

import java.util.*;

public class ShopService {

    Shop shop;

    public ShopService(Shop shop) {
        this.shop = shop;
    }

    public SortedSet<Notebook> getNotebooksSortedByName() {
        SortedSet<Notebook> result = new TreeSet<Notebook>(Comparator.comparing(Notebook::getName));
        result.addAll(shop.getNotebooks());
        return result;
    }

    public Set<Notebook> searchNotebooksByPartOfName(String name) {
        Set<Notebook> result = new HashSet<>();

        for (Notebook notebook : shop.getNotebooks()) {
            if (notebook.getName().contains(name))
                result.add(notebook);
        }

        return result;
    }

    public Set<Notebook> searchNotebooksByOperatingSystem(Notebook.OperatingSystem operatingSystem) {
        Set<Notebook> result = new HashSet<>();

        for (Notebook notebook : shop.getNotebooks()) {
            if (notebook.getOperatingSystem().equals(operatingSystem))
                result.add(notebook);
        }

        return result;
    }

    public Set<Notebook> searchNotebooksByPrice(Integer minPrice, Integer maxPrice) {
        Set<Notebook> result = new HashSet<>();

        for (Notebook notebook : shop.getNotebooks()) {
            if (notebook.getPrice() >= minPrice && notebook.getPrice() <= maxPrice)
                result.add(notebook);
        }

        return result;
    }



}
