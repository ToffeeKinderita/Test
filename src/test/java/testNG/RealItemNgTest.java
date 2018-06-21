package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

public class RealItemNgTest {
    private static final double WEIGHT = 159.0;
    private RealItem real = new RealItem();

    @Test(groups = {"other", "realItemTest"})
    public void getWeightofRealItemTest() {
        Cart item = new Cart("abc");
        real.setWeight(WEIGHT);
        item.addRealItem(real);
        Assert.assertEquals(real.getWeight(), WEIGHT, "Weight should be 159.0");
    }

    @Test
    public void dispalyWeightTest() {
        real.setWeight(WEIGHT);
        Assert.assertEquals(real.toString(), "Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 159.0");
    }
}