import org.junit.Assert;
import org.junit.jupiter.api.Test;
import shop.RealItem;

public class RealItemTest {

    @Test
    public void dispalyWeightTest() {
        RealItem realit = new RealItem();
        realit.setWeight(1.55);
        Assert.assertEquals("Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 1.55", realit.toString());
    }
}