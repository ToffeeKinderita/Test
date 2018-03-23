import org.junit.Assert;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;


public class Test_Cart {
    @Test
    public void test_getTotalPrice(){
        Cart item = new Cart("test cart");
        RealItem phone = new RealItem();
        phone.setPrice(123);
        item.addRealItem(phone);
        Assert.assertEquals(147.6, item.getTotalPrice(),147.6);
        }
}
