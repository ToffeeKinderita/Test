package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;

public class CartNgTest {
    private static final String CARTNAME = "test cart";

    @Test(groups = {"other"})
    public void removeRealItemTest() {
        Cart item = new Cart(CARTNAME);
        Assert.assertEquals(item.getCartName(), "test cart", "The Name of the Cart should be 'test cart'");
    }
}
