import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CartTest {

    @Test
    public void getTotalPriceTest() {
        Cart item = new Cart("test cart");
        RealItem phone = new RealItem();
        phone.setPrice(123);
        item.addRealItem(phone);
        assertEquals(147.6, item.getTotalPrice(), "TotalPrice for item with Price 123 should be 147.6");
    }
}