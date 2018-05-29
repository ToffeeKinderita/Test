package jsonParser.jsonParserTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.JsonParser;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.*;

import static jsonParser.jsonParserHelpers.RandomStringGenerator.Mode.NUMERIC;
import static jsonParser.jsonParserHelpers.RandomStringGenerator.generateRandomString;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParserTests {
    public Parser parser = new JsonParser();
    public Cart somecart = new Cart("Test" + generateRandomString(2, NUMERIC));
    public RealItem car = new RealItem();
    public VirtualItem disk = new VirtualItem();

    @BeforeEach
    public void start() {
        car.setName("ABC");
        car.setPrice(1234);
        car.setWeight(1234);
        somecart.addRealItem(car);
        disk.setName("NBD");
        disk.setPrice(5640);
        disk.setSizeOnDisk(1024);
        somecart.addVirtualItem(disk);
        parser.writeToFile(somecart);
    }

    @Test
    @DisplayName("Reading_JSON_File_With_All_Items_Added")
    public void writeToFileTest() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + somecart.getCartName() + ".json"));
        String file = reader.readLine();
        assertEquals("{\"cartName\":\"" + somecart.getCartName() + "\",\"realItems\":[{\"weight\":1234.0,\"name\":\"ABC\",\"price\":1234.0}],\"virtualItems\":[{\"sizeOnDisk\":1024.0,\"name\":\"NBD\",\"price\":5640.0}],\"total\":8248.8}", file);
    }

    @Test
    @DisplayName("Grouped_assertions")
    public void groupAssertTest() {
        assertAll(
                () -> assertEquals(8248.8, somecart.getTotalPrice()),
                () -> assertEquals(Cart.class, somecart.getClass())
        );
    }

}