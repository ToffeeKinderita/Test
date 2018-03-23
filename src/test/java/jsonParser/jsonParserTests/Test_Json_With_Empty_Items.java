package jsonParser.jsonParserTests;

import jsonParser.jsonParserHelpers.Json_HelperClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.Cart;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Json_With_Empty_Items extends Json_HelperClass {

    @Test
    @DisplayName("Test_With_Cart_Name_and_no_Items")
    public void test_withNoItems() throws IOException {
        parser.writeToFile(somecart);
        assertEquals("{\"cartName\":\"" + somecart.getCartName() + "\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}", filename(somecart));

    }

    @Test
    @DisplayName("Test_With_Null_Cart_Name_and_no_Items")
    public void test_NullCartNameAndNoItems() throws IOException {
        Cart nullName = new Cart(null);
        parser.writeToFile(nullName);
        assertEquals("{\"realItems\":[],\"virtualItems\":[],\"total\":0.0}", filename(nullName));
    }

    @Test
    @DisplayName("Test_With_Cart_Name_and_Empty_RealItem/Virt_Added_to_Cart")
    public void test_emptyRealI_VirttemsAdded() throws IOException {
        somecart.addRealItem(car);
        somecart.addVirtualItem(disk);
        parser.writeToFile(somecart);
        assertEquals("{\"cartName\":\"" + somecart.getCartName() + "\",\"realItems\":[{\"weight\":0.0,\"price\":0.0}],\"virtualItems\":[{\"sizeOnDisk\":0.0,\"price\":0.0}],\"total\":0.0}", filename(somecart));


    }
}
