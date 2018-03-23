package jsonParser.jsonParserHelpers;

import com.google.gson.Gson;
import parser.JsonParser;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static jsonParser.jsonParserHelpers.RandomStringGenerator.Mode.NUMERIC;
import static jsonParser.jsonParserHelpers.RandomStringGenerator.generateRandomString;

public class Json_HelperClass {
    public static final Gson gson = new Gson();
    public Parser parser = new JsonParser();
    public RealItem car = new RealItem();
    public VirtualItem disk = new VirtualItem();


    public Cart somecart = new Cart("Test" + generateRandomString(2, NUMERIC));

    public static boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public void create(String nameReal, double realPrice, double realWeight, String nameVirt, double virtPrice, double virtSize) {
        car.setName(nameReal);
        car.setPrice(realPrice);
        car.setWeight(realWeight);
        somecart.addRealItem(car);
        disk.setName(nameVirt);
        disk.setPrice(virtPrice);
        disk.setSizeOnDisk(virtSize);
        somecart.addVirtualItem(disk);
    }

    public String filename(Cart cart) throws IOException {
        String a = cart.getCartName();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + a + ".json"));
        return reader.readLine();
    }


}


