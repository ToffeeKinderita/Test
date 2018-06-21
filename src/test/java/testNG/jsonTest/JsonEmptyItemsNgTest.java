package testNG.jsonTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonEmptyItemsNgTest extends ConfigurationClass {

    @Test(enabled = false, groups = {"JSONtestReg"})
    public void testWithNoItems() throws IOException {
        Cart empty = new Cart("empty");
        parser.writeToFile(empty);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + empty.getCartName() + ".json"));
        String file = reader.readLine();
        Assert.assertEquals(file, "{\"cartName\":\"" + empty.getCartName() + "\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}");
    }

    @Test(groups = {"JSONtestReg"})
    public void testNullCartNameAndNoItems() throws IOException {
        Cart nullName = new Cart(null);
        parser.writeToFile(nullName);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + nullName.getCartName() + ".json"));
        String file = reader.readLine();
        Assert.assertEquals(file, "{\"realItems\":[],\"virtualItems\":[],\"total\":0.0}");
    }

    @Test(groups = {"JSONtestReg"})
    public void testEmptyRealIAndVirtItemsAdded() throws IOException {
        somecart.addRealItem(car);
        somecart.addVirtualItem(disk);
        parser.writeToFile(somecart);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + somecart.getCartName() + ".json"));
        String file = reader.readLine();
        Assert.assertEquals(file, "{\"cartName\":\"" + somecart.getCartName() + "\",\"realItems\":[{\"weight\":0.0,\"price\":0.0}],\"virtualItems\":[{\"sizeOnDisk\":0.0,\"price\":0.0}],\"total\":0.0}");
    }
}
