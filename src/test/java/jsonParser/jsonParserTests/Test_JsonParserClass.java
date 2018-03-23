package jsonParser.jsonParserTests;

import jsonParser.jsonParserHelpers.Json_HelperClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test_JsonParserClass extends Json_HelperClass {

    @BeforeEach
    public void start() {
        create("ABC", 1234, 1234, "NBD", 5640, 1024);
        parser.writeToFile(somecart);
    }

    @Test
    @DisplayName("Test_Valid_JSON_Format")
    public void test_JSONformat() throws IOException {
        boolean abc = isJSONValid(filename(somecart));
        assertTrue(abc);
    }

    @Test
    @DisplayName("Reading_JSON_File_With_All_Items_Added")
    public void test_writeToFile() throws IOException {
        assertEquals("{\"cartName\":\"" + somecart.getCartName() + "\",\"realItems\":[{\"weight\":1234.0,\"name\":\"ABC\",\"price\":1234.0}],\"virtualItems\":[{\"sizeOnDisk\":1024.0,\"name\":\"NBD\",\"price\":5640.0}],\"total\":8248.8}", filename(somecart));
    }

    @Test
    @DisplayName("Grouped_assertions")
    public void test_groupAssert() {
        assertAll(
                () -> assertEquals(8248.8, somecart.getTotalPrice()),
                () -> assertEquals(Cart.class, somecart.getClass())
        );
    }

}