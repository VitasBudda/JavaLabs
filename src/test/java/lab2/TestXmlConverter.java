package lab2;

import lab2.exception.ConvertException;
import lab2.model.Notebook;
import lab2.model.Shop;
import lab2.service.converter.XmlConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestXmlConverter {


    private XmlConverter<Notebook> notebookXmlConverter;
    private XmlConverter<Shop> shopXmlConverter;

    private Notebook acerAspire;
    private Notebook macBook;
    private Notebook asusPro;
    private Notebook hpLight;

    private Shop notebookShop;

    @BeforeTest
    public void beforeTest() {
        notebookXmlConverter = new XmlConverter<>(Notebook.class);
        shopXmlConverter = new XmlConverter<>(Shop.class);

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

        notebookShop = new Shop("Notebook Store");
        notebookShop.addNotebook(acerAspire);
        notebookShop.addNotebook(macBook);
        notebookShop.addNotebook(asusPro);
        notebookShop.addNotebook(hpLight);
    }

    @Test
    public void serializeNotebookToStringTest() throws ConvertException {
        String expected = "<Notebook><name>Acer Aspire E15</name><operatingSystem>WINDOWS</operatingSystem><weight>2.3</weight><displayDiagonal>14.5</displayDiagonal><memoryCapacity>512</memoryCapacity><ram>8192</ram><price>13000</price></Notebook>";
        String actual = notebookXmlConverter.serializeToString(acerAspire);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeNotebookFromStringTest() throws ConvertException {
        String json = "<Notebook><name>Acer Aspire E15</name><operatingSystem>WINDOWS</operatingSystem><weight>2.3</weight><displayDiagonal>14.5</displayDiagonal><memoryCapacity>512</memoryCapacity><ram>8192</ram><price>13000</price></Notebook>";
        Notebook notebook = notebookXmlConverter.deserializeString(json);
        Assert.assertEquals(notebook, acerAspire);
    }

    @Test(expectedExceptions = ConvertException.class)
    public void negativeDeserializeStringTest() throws ConvertException {
        String json = "<Notebook><operatingSystem>WINDOWS</operatingSystem><weight>2.3</weight><displayDiagonal>14.5</displayDiagonal><memoryCapacity>512</memoryCapacity><ram>8192</ram><price>13000</price></Notebook>";
        notebookXmlConverter.deserializeString(json);
    }

    @Test
    public void deserializeShopFromStringTest() throws ConvertException {
        String json = "<Shop><name>Notebook Store</name><notebooks><notebooks><name>MacBook Pro 15</name><operatingSystem>MAC_OS</operatingSystem><weight>1.6</weight><displayDiagonal>15.0</displayDiagonal><memoryCapacity>1024</memoryCapacity><ram>8192</ram><price>24000</price></notebooks><notebooks><name>HP Light</name><operatingSystem>LINUX</operatingSystem><weight>1.8</weight><displayDiagonal>13.5</displayDiagonal><memoryCapacity>1024</memoryCapacity><ram>4096</ram><price>10000</price></notebooks><notebooks><name>Asus Pro 2019</name><operatingSystem>WINDOWS</operatingSystem><weight>2.0</weight><displayDiagonal>16.0</displayDiagonal><memoryCapacity>1024</memoryCapacity><ram>8192</ram><price>19000</price></notebooks><notebooks><name>Acer Aspire E15</name><operatingSystem>WINDOWS</operatingSystem><weight>2.3</weight><displayDiagonal>14.5</displayDiagonal><memoryCapacity>512</memoryCapacity><ram>8192</ram><price>13000</price></notebooks></notebooks></Shop>";
        Shop shop = shopXmlConverter.deserializeString(json);
        Assert.assertEquals(shop, notebookShop);
    }

}
