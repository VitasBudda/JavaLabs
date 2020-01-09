package lab3.service;

import lab3.model.Notebook;
import lab3.model.Shop;

import java.util.*;
import java.util.stream.Collectors;

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
        return shop.getNotebooks().stream()
                .filter(n -> n.getName().contains(name))
                .collect(Collectors.toSet());
    }

    public Set<Notebook> searchNotebooksByOperatingSystem(Notebook.OperatingSystem operatingSystem) {
        return shop.getNotebooks().stream()
                .filter(n -> n.getOperatingSystem().equals(operatingSystem))
                .collect(Collectors.toSet());
    }

    public Set<Notebook> searchNotebooksByPrice(Integer minPrice, Integer maxPrice) {
        return shop.getNotebooks().stream()
                .filter(n -> n.getPrice() >= minPrice && n.getPrice() <= maxPrice)
                .collect(Collectors.toSet());
    }

}
