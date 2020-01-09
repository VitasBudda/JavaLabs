package lab2;

import lab2.exception.ConvertException;
import lab2.model.Notebook;
import lab2.model.Shop;
import lab2.service.converter.JsonConverter;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestJsonConverter {

    private JsonConverter<Notebook> notebookJsonConverter;
    private JsonConverter<Shop> shopJsonConverter;

    private Notebook acerAspire;
    private Notebook macBook;
    private Notebook asusPro;
    private Notebook hpLight;

    private Shop notebookShop;

    @BeforeTest
    public void beforeTest() {
        notebookJsonConverter = new JsonConverter<>(Notebook.class);
        shopJsonConverter = new JsonConverter<>(Shop.class);

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
        String expected = "{\"name\":\"Acer Aspire E15\",\"operatingSystem\":\"WINDOWS\",\"weight\":2.3,\"displayDiagonal\":14.5,\"memoryCapacity\":512,\"ram\":8192,\"price\":13000}";
        String actual = notebookJsonConverter.serializeToString(acerAspire);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeNotebookFromStringTest() throws ConvertException {
        String json = "{\"name\":\"Acer Aspire E15\",\"operatingSystem\":\"WINDOWS\",\"weight\":2.3,\"displayDiagonal\":14.5,\"memoryCapacity\":512,\"ram\":8192,\"price\":13000}";
        Notebook notebook = notebookJsonConverter.deserializeString(json);
        Assert.assertEquals(notebook, acerAspire);
    }

    @Test(expectedExceptions = ConvertException.class)
    public void negativeDeserializeStringTest() throws ConvertException {
        String json = "{\"name\":\"Acer Aspire E15\",\"weight\":2.3,\"displayDiagonal\":14.5,\"memoryCapacity\":512,\"ram\":8192,\"price\":13000}";
        notebookJsonConverter.deserializeString(json);
    }

    @Test
    public void serializeShopToStringTest() throws ConvertException, JSONException {
        String expected = "{\"name\":\"Notebook Store\",\"notebooks\":[{\"name\":\"Acer Aspire E15\",\"operatingSystem\":\"WINDOWS\",\"weight\":2.3,\"displayDiagonal\":14.5,\"memoryCapacity\":512,\"ram\":8192,\"price\":13000},{\"name\":\"HP Light\",\"operatingSystem\":\"LINUX\",\"weight\":1.8,\"displayDiagonal\":13.5,\"memoryCapacity\":1024,\"ram\":4096,\"price\":10000},{\"name\":\"Asus Pro 2019\",\"operatingSystem\":\"WINDOWS\",\"weight\":2.0,\"displayDiagonal\":16.0,\"memoryCapacity\":1024,\"ram\":8192,\"price\":19000},{\"name\":\"MacBook Pro 15\",\"operatingSystem\":\"MAC_OS\",\"weight\":1.6,\"displayDiagonal\":15.0,\"memoryCapacity\":1024,\"ram\":8192,\"price\":24000}]}";
        String actual = shopJsonConverter.serializeToString(notebookShop);
        JSONAssert.assertEquals(actual, expected, false);
    }

    @Test
    public void deserializeShopFromStringTest() throws ConvertException {
        String json = "{\"name\":\"Notebook Store\",\"notebooks\":[{\"name\":\"Acer Aspire E15\",\"operatingSystem\":\"WINDOWS\",\"weight\":2.3,\"displayDiagonal\":14.5,\"memoryCapacity\":512,\"ram\":8192,\"price\":13000},{\"name\":\"HP Light\",\"operatingSystem\":\"LINUX\",\"weight\":1.8,\"displayDiagonal\":13.5,\"memoryCapacity\":1024,\"ram\":4096,\"price\":10000},{\"name\":\"Asus Pro 2019\",\"operatingSystem\":\"WINDOWS\",\"weight\":2.0,\"displayDiagonal\":16.0,\"memoryCapacity\":1024,\"ram\":8192,\"price\":19000},{\"name\":\"MacBook Pro 15\",\"operatingSystem\":\"MAC_OS\",\"weight\":1.6,\"displayDiagonal\":15.0,\"memoryCapacity\":1024,\"ram\":8192,\"price\":24000}]}";
        Shop shop = shopJsonConverter.deserializeString(json);
        Assert.assertEquals(shop, notebookShop);
    }

}
