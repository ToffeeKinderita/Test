package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

public class RealItemNgTest {

    @Test(groups = {"other", "realItemTest"})
    public void getWeightofRealItemTest() {
        RealItem real = new RealItem();
        Cart item = new Cart("abc");
        real.setWeight(159);
        item.addRealItem(real);
        Assert.assertEquals(real.getWeight(), 159.0, "Weight should be 159.0");
    }
}