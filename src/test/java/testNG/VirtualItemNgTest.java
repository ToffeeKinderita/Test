package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;
import shop.VirtualItem;

public class VirtualItemNgTest {
    private static final double SIZE = 9898.0;
    private VirtualItem virt = new VirtualItem();

    @Test(groups = {"other"})
    public void getSizeOfVirtItemTest() {
        Cart item = new Cart("abc");
        virt.setSizeOnDisk(SIZE);
        item.addVirtualItem(virt);
        Assert.assertEquals(virt.getSizeOnDisk(), SIZE, "SizeOnDisk should be 9898.0");
    }

    @Test
    public void dispalySizeTest() {
        virt.setSizeOnDisk(SIZE);
        Assert.assertEquals(virt.toString(), "Class: class shop.VirtualItem; Name: null; Price: 0.0; Size on disk: 9898.0");
    }
}