import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualItemTest {

    @Test
    public void dispalySizeTest() {
        VirtualItem realit = new VirtualItem();
        realit.setSizeOnDisk(1.55);
        assertEquals("Class: class shop.VirtualItem; Name: null; Price: 0.0; Size on disk: 1.55", realit.toString());
    }
}