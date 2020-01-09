package lab1;

import lab1.model.Notebook;
import lab1.model.Shop;
import lab1.service.ShopService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.SortedSet;

public class TestShop {

    private Shop shop;
    private ShopService shopService;

    private Notebook acerAspire;
    private Notebook macBook;
    private Notebook asusPro;
    private Notebook hpLight;

    @BeforeTest
    public void beforeTest() {
        acerAspire = new Notebook.Builder()
                .setName("Acer Aspire E15")
                .setDisplayDiagonal(14.5f)
                .setMemoryCapacity(512)
                .setRam(8192)
                .setOperatingSystem(Notebook.OperatingSystem.WINDOWS)
                .setWeight(2.3f)
                .setPrice(13000)
                .build();

        macBook = new Notebook.Builder()
                .setName("MacBook Pro 15")
                .setDisplayDiagonal(15f)
                .setMemoryCapacity(1024)
                .setRam(8192)
                .setOperatingSystem(Notebook.OperatingSystem.MAC_OS)
                .setWeight(1.6f)
                .setPrice(24000)
                .build();

        asusPro = new Notebook.Builder()
                .setName("Asus Pro 2019")
                .setDisplayDiagonal(16f)
                .setMemoryCapacity(1024)
                .setRam(8192)
                .setOperatingSystem(Notebook.OperatingSystem.WINDOWS)
                .setWeight(2f)
                .setPrice(19000)
                .build();

        hpLight = new Notebook.Builder()
                .setName("HP Light")
                .setDisplayDiagonal(13.5f)
                .setMemoryCapacity(1024)
                .setRam(4096)
                .setOperatingSystem(Notebook.OperatingSystem.LINUX)
                .setWeight(1.8f)
                .setPrice(10000)
                .build();
    }

    @BeforeMethod
    public void beforeMethod() {
        shop = new Shop("Notebook Store");
        shop.addNotebook(acerAspire);
        shop.addNotebook(macBook);
        shop.addNotebook(asusPro);
        shop.addNotebook(hpLight);
        shopService = new ShopService(shop);
    }

    // Shop test

    @Test
    public void addNotebookTest() {
        Notebook notebook = new Notebook.Builder()
                .setName("Gaming Notebook")
                .setDisplayDiagonal(17f)
                .setMemoryCapacity(1024)
                .setRam(8192)
                .setOperatingSystem(Notebook.OperatingSystem.WINDOWS)
                .setWeight(13.5f)
                .setPrice(16000)
                .build();

        int countBefore = shop.getNotebooks().size();
        shop.addNotebook(notebook);
        int countAfter = shop.getNotebooks().size();

        Assert.assertEquals(countAfter, countBefore + 1);
    }

    @Test
    public void removeNotebookTest() {
        int countBefore = shop.getNotebooks().size();
        shop.removeNotebook(macBook);
        int countAfter = shop.getNotebooks().size();

        Assert.assertEquals(countAfter, countBefore - 1);
    }

    // ShopService test

    @Test
    public void getNotebooksSortedByNameTest() {
        SortedSet<Notebook> notebooks = shopService.getNotebooksSortedByName();

        Object[] actual = notebooks.toArray();
        Object[] expected = { acerAspire, asusPro, hpLight, macBook };

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void searchNotebooksByPartOfNameTest() {
        Set<Notebook> notebooks = shopService.searchNotebooksByPartOfName("Pro");

        Object[] actual = notebooks.toArray();
        Object[] expected = { asusPro, macBook };

        Assert.assertEqualsNoOrder(actual, expected);
    }

    @Test
    public void searchNotebooksByOperatingSystemTest() {
        Set<Notebook> notebooks = shopService.searchNotebooksByOperatingSystem(Notebook.OperatingSystem.WINDOWS);

        Object[] actual = notebooks.toArray();
        Object[] expected = { asusPro, acerAspire };

        Assert.assertEqualsNoOrder(actual, expected);
    }

    @Test
    public void searchNotebooksByPriceTest() {
        Set<Notebook> notebooks = shopService.searchNotebooksByPrice(11000, 20000);

        Object[] actual = notebooks.toArray();
        Object[] expected = { asusPro, acerAspire };

        Assert.assertEqualsNoOrder(actual, expected);
    }

}
