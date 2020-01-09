package lab1;

import lab1.model.Notebook;
import org.testng.annotations.Test;

public class TestNotebook {

    @Test
    public void builderTest() {
        Notebook notebook = new Notebook.Builder()
                .setName("Acer Aspire E15")
                .setDisplayDiagonal(13f)
                .setMemoryCapacity(512)
                .setRam(8192)
                .setOperatingSystem(Notebook.OperatingSystem.WINDOWS)
                .setWeight(2.3f)
                .setPrice(13000)
                .build();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test(expectedExceptions = IllegalStateException.class)
    public void builderNegativeTest1() {
        Notebook notebook = new Notebook.Builder()
                .setName("Acer Aspire E15")
                .setDisplayDiagonal(13f)
                .setMemoryCapacity(512)
                .setRam(-8096)
                .setOperatingSystem(Notebook.OperatingSystem.WINDOWS)
                .setWeight(2.3f)
                .setPrice(-13000)
                .build();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void builderNegativeTest2() {
        Notebook notebook = new Notebook.Builder()
                .build();
    }

}
