package lab0;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestVariant22 {

    private Variant22 variant22 = new Variant22();

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] inputOutputProvider() {
        return new Object[][] { { 1, 2, 2, 1 }, { -5, 6, 6, -5 } };
    }

    @Test(dataProvider = "inputOutputProvider")
    public void inputOutputTest(int a, int b, int expectedA, int expectedB) {
        Assert.assertEquals(variant22.inputOutputTask(a, b), new Pair(expectedA, expectedB));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] integerTaskProvider() {
        return new Object[][] { { 3602, 2 }, {119554, 754}, { 7504, 304 } };
    }

    @Test(dataProvider = "integerTaskProvider")
    public void integerTaskTest(int number, int expected) {
        Assert.assertEquals(variant22.integerTask(number), expected);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] booleanTaskProvider() {
        return new Object[][] { { 159, true }, { 321, true }, { 951, true },
                { 312, false }, { 519, false }, { 666, false } };
    }

    @Test(dataProvider = "booleanTaskProvider")
    public void booleanTaskTest(int number, boolean expectedResult) {
        Assert.assertEquals(variant22.booleanTask(number), expectedResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void booleanNegativeTest() {
        variant22.booleanTask(1000);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] conditionTaskProvider() {
        return new Object[][] { { 5, 5, 1 }, { -5, 5, 2 }, { -5, -5, 3}, { 5, -5, 4 } };
    }

    @Test(dataProvider = "conditionTaskProvider")
    public void conditionTaskTest(int x, int y, int expected) {
        Assert.assertEquals(variant22.conditionTask(x, y), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void conditionNegativeTaskTest() {
        variant22.conditionTask(0, 0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] switchTaskProvider() {
        return new Object[][] { { 1, "very bad" }, { 2, "bad" },
                { 3, "normal" }, { 4, "good" }, { 5, "excellent" },
                { 0, "error" }, { 6, "error" } };
    }

    @Test(dataProvider = "switchTaskProvider")
    public void switchTaskTest(int number, String expected) {
        Assert.assertEquals(variant22.switchTask(number), expected);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] forTaskProvider() {
        return new Object[][] { { 2, 4, 7.0f }, { 3, 9, 20.063395f }, { 4, 1, 5.0f } };
    }

    @Test(dataProvider = "forTaskProvider")
    public void forTaskTest(float x, int n, float expected) {
        Assert.assertEquals(variant22.forTask(x, n), expected);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] whileTaskProvider() {
        return new Object[][] { { 2, true }, { 3, true }, { 5, true }, { 6, false } };
    }

    @Test(dataProvider = "whileTaskProvider")
    public void whileTaskTest(int n, boolean expected) {
        Assert.assertEquals(variant22.whileTask(n), expected);
    }
 
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void whileTaskExceptionTest() {
        variant22.whileTask(-1);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] arrayTaskProvider() {
        return new Object[][] { { new Integer[] { 4, 5, 6, 7, 8 }, 1, 3, 18 } };
    }

    @Test(dataProvider = "arrayTaskProvider")
    public void arrayTaskTest(Integer[] arr, int k, int l, int expected) {
        Assert.assertEquals(variant22.arrayTask(arr, k, l), expected);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    public Object[][] twoDimensionArrayTaskProvider() {
        return new Object[][]
        {
           {
               new Integer[][]
               {
                    { 1, 2, 3, 4, 5 },
                    { 1, 2, 3, 4, 5 },
                    { 1, 2, 3, 4, 5 }
               },
               new Integer[] { 6, 12 }
           }
        };
    }

    @Test(dataProvider = "twoDimensionArrayTaskProvider")
    public void twoDimensionArrayTaskTest(Integer[][] arr, Integer[] result) {
        Assert.assertEquals(variant22.twoDimensionTask(arr), result);
    }

}
