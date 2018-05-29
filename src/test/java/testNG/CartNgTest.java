package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;

public class CartNgTest {

    @Test(groups = {"other"})
    public void removeRealItemTest() {
        Cart item = new Cart("test cart");
        Assert.assertEquals(item.getCartName(), "test cart", "The Name of the Cart should be 'test cart'");

    }
}
