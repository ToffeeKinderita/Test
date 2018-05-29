package jUnit;

import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealItemTest {

    @Test
    public void dispalyWeightTest() {
        RealItem realit = new RealItem();
        realit.setWeight(1.55);
        assertEquals("Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 1.55", realit.toString());
    }
}