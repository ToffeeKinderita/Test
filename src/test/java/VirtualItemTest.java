import org.junit.Assert;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

public class VirtualItemTest {

    @Test
    public void dispalySizeTest() {
        VirtualItem realit = new VirtualItem();
        realit.setSizeOnDisk(1.55);
        Assert.assertEquals("Class: class shop.VirtualItem; Name: null; Price: 0.0; Size on disk: 1.55", realit.toString());
    }
}