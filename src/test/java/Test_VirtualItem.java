import org.junit.Assert;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

public class Test_VirtualItem {

    @Test
    public void test_dispalySize(){
        VirtualItem realit = new VirtualItem();
        realit.setSizeOnDisk(1.55);
        Assert.assertEquals("Class: class shop.VirtualItem; Name: null; Price: 0.0; Size on disk: 1.55", realit.toString());
    }
}
