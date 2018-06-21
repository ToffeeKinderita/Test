package jUnit.jsonParser.jsonParserTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import shop.Cart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonWithEmptyItemsTest extends JsonParserTest {

    @Test
    @DisplayName("Test_With_Cart_Name_and_no_Items")
    public void testWithNoItems() throws IOException {
        parser.writeToFile(somecart);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + somecart.getCartName() + ".json"));
        String file = reader.readLine();
        assertEquals("{\"cartName\":\"" + somecart.getCartName() + "\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}", file);
    }

    @Disabled
    @Test
    @DisplayName("Test_With_Null_Cart_Name_and_no_Items")
    public void testNullCartNameAndNoItems() throws IOException {
        Cart nullName = new Cart(null);
        parser.writeToFile(nullName);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + nullName.getCartName() + ".json"));
        String file = reader.readLine();
        assertEquals("{\"realItems\":[],\"virtualItems\":[],\"total\":0.0}", file);
    }

    @Test
    @DisplayName("Test_With_Cart_Name_and_Empty_RealItem/Virt_Added_to_Cart")
    public void testEmptyRealIAndVirtItemsAdded() throws IOException {
        somecart.addRealItem(car);
        somecart.addVirtualItem(disk);
        parser.writeToFile(somecart);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + somecart.getCartName() + ".json"));
        String file = reader.readLine();
        assertEquals("{\"cartName\":\"" + somecart.getCartName() + "\",\"realItems\":[{\"weight\":0.0,\"price\":0.0}],\"virtualItems\":[{\"sizeOnDisk\":0.0,\"price\":0.0}],\"total\":0.0}", file);
    }
}