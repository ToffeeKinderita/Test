import org.junit.Assert;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;


public class CartTest {

    @Test
    public void getTotalPriceTest() {
        Cart item = new Cart("test cart");
        RealItem phone = new RealItem();
        phone.setPrice(123);
        item.addRealItem(phone);
        Assert.assertEquals("TotalPrice for item with Price 123 should be 147.6: ", 147.6, item.getTotalPrice(), 147.6);
    }
}