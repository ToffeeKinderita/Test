package testNG.jsonTest;

import org.testng.annotations.BeforeGroups;
import parser.JsonParser;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static jUnit.jsonParser.jsonParserHelper.RandomStringGenerator.Mode.NUMERIC;
import static jUnit.jsonParser.jsonParserHelper.RandomStringGenerator.generateRandomString;

public abstract class ConfigurationClass {
    public Parser parser = new JsonParser();
    public Cart somecart = new Cart("Test" + generateRandomString(3, NUMERIC));
    public RealItem car = new RealItem();
    public VirtualItem disk = new VirtualItem();

    @BeforeGroups(groups = "JSONtest", alwaysRun = true)
    public void startTest() {
        car.setName("ABCB");
        car.setPrice(1234);
        car.setWeight(1234);
        somecart.addRealItem(car);
        disk.setName("NBD");
        disk.setPrice(5640);
        disk.setSizeOnDisk(1024);
        somecart.addVirtualItem(disk);
        parser.writeToFile(somecart);
        System.out.println("before");
    }
}
