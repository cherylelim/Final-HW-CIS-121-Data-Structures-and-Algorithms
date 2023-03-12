import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class Question4Test {

    @Test
    public void givenTest() {
        HashSet<String> set = new HashSet<String>();
        set.add("MIA");
        set.add("JFK");
        set.add("MLA");
        set.add("MLE");
        set.add("BLE");
        List<String> expected = new ArrayList<String>();
        expected.add("MIA");
        expected.add("MLA");
        expected.add("MLE");
        expected.add("BLE");
        Assert.assertEquals(expected, Question4.getSmallestChain("MIA", "BLE", set));

    }

    @Test
    public void test1() {
        HashSet<String> set = new HashSet<String>();
        set.add("MIA");
        set.add("MLA");
        set.add("MID");
        List<String> expected = new ArrayList<String>();
        expected.add("MLA");
        expected.add("MIA");
        expected.add("MID");
        Assert.assertEquals(expected, Question4.getSmallestChain("MLA", "MID", set));
    }

    @Test
    public void noAnswer() {
        HashSet<String> set = new HashSet<String>();
        set.add("MIA");
        set.add("JFK");
        set.add("MLA");
        set.add("MLE");
        set.add("BLE");
        Assert.assertNull(Question4.getSmallestChain("MIA", "JFK", set));
    }

    @Test
    public void codesAreSame() {
        HashSet<String> set = new HashSet<String>();
        set.add("MIA");
        List<String> expected = new ArrayList<String>();
        Assert.assertEquals(expected, Question4.getSmallestChain("MIA", "MIA", set));
    }
}
