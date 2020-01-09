package lab2;

import lab2.exception.ConvertException;
import lab2.model.Notebook;
import lab2.service.converter.NotebookTextConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNotebookTextConverter {

    private NotebookTextConverter notebookTextConverter;
    private Notebook notebook;

    {
        notebookTextConverter = new NotebookTextConverter();
    }

    @BeforeMethod
    public void beforeMethod() {
        notebook = new Notebook.Builder()
                .setName("Acer Aspire E15")
                .setDisplayDiagonal(14.5f)
                .setMemoryCapacity(512)
                .setRam(8192)
                .setOperatingSystem(Notebook.OperatingSystem.WINDOWS)
                .setWeight(2.3f)
                .setPrice(13000)
                .build();
    }

    @Test
    public void serializeToStringTest() throws ConvertException {
        String expected = "Acer Aspire E15~~WINDOWS~~14.5~~512~~8192~~2.3~~13000";
        String actual = notebookTextConverter.serializeToString(notebook);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeStringTest() throws ConvertException {
        String serialized = "Acer Aspire E15~~WINDOWS~~14.5~~512~~8192~~2.3~~13000";
        Notebook actual = notebookTextConverter.deserializeString(serialized);
        Assert.assertEquals(actual, notebook);
    }


    @DataProvider
    public Object[][] negativeDeserializeStringDataProvider() {
        return new Object[][]{
                {"Acer Aspire E15~~TEST~~14.5~~512~~8192~~2.3~~13000"},
                {"Acer Aspire E15~~WINDOWS~~TEST~~512~~8192~~2.3~~13000"},
                {"Acer Aspire E15~~WINDOWS~~14.5~~512~~8192~~2.3"},
                {"Acer Aspire E15~~WINDOWS~~14.5~~512.5~~8192~~2.3~~13000"}
        };
    }

    @Test(expectedExceptions = ConvertException.class, dataProvider = "negativeDeserializeStringDataProvider")
    public void negativeDeserializeStringTest(String serializedString) throws ConvertException {
        notebookTextConverter.deserializeString(serializedString);
    }

}
