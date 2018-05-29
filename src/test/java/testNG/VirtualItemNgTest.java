package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;
import shop.VirtualItem;

public class VirtualItemNgTest {

    @Test(groups = {"other"})
    public void getSizeOfVirtItemTest() {
        VirtualItem virt = new VirtualItem();
        Cart item = new Cart("abc");
        virt.setSizeOnDisk(9898);
        item.addVirtualItem(virt);
        Assert.assertEquals(virt.getSizeOnDisk(), 9898.0, "SizeOnDisk should be 9898.0");

    }
}