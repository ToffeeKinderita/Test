package testNG.jsonTest;


import com.google.gson.JsonSyntaxException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;

import java.io.File;

public class ExceptionNgTest {
    public Parser parser = new JsonParser();

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"badJson1.json"},
                new Object[]{"badJson2.json"},
                new Object[]{"2017-Scrum-Guide-US.pdf"},
                new Object[]{"badJson3.json"},
                new Object[]{"badJson4.json"},
        };
    }

    @Test(groups = {"JSONtestReg"})
    @Parameters({"path"})
    public void testNoSuchFileException(String path) {
        Assert.assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File(path));
        });
    }

    @Test(dataProvider = "testData", groups = {"JSONtestReg"})
    public void testJSONException(String path) {
        Assert.assertThrows(JsonSyntaxException.class, () -> {
            parser.readFromFile(new File("src/main/resources/" + path));
        });
    }

}