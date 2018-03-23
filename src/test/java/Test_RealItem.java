import org.junit.Assert;
import org.junit.jupiter.api.Test;
import shop.RealItem;

public class Test_RealItem {
    @Test
    public void test_dispalyWeight(){
        RealItem realit = new RealItem();
        realit.setWeight(1.55);
        Assert.assertEquals("Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 1.55", realit.toString());
    }
}
