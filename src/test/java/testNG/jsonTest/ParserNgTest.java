package testNG.jsonTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import shop.Cart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParserNgTest extends ConfigurationClass {

    @Test(groups = {"JSONtest", "JSONtestReg"})
    public void writeToFileTest() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + somecart.getCartName() + ".json"));
        String file = reader.readLine();
        Assert.assertEquals(file, "{\"cartName\":\"" + somecart.getCartName() + "\",\"realItems\":[{\"weight\":1234.0,\"name\":\"ABCB\",\"price\":1234.0}],\"virtualItems\":[{\"sizeOnDisk\":1024.0,\"name\":\"NBD\",\"price\":5640.0}],\"total\":8248.8}");
    }

    @Test(groups = {"JSONtest", "JSONtestReg"})
    public void groupAssertTest() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(somecart.getTotalPrice(), 8248.8);
        soft.assertEquals(somecart.getClass(), Cart.class);
        soft.assertAll();
    }
}