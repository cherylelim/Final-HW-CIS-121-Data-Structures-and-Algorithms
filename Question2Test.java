import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class Question2Test {

    @Test
    public void givenTest() {
        String[][] requests = { {"Steven", "Will"}, {"Helen", "Caroline"}, {"Caroline", "Monal"}, {"Will", "Steven"} };
        HashSet<Pair<String,String>> expected = new HashSet<Pair<String,String>>();
        expected.add(new Pair("Steven", "Will"));
        Set<Pair<String,String>> result = Question2.findMatches(requests);
        Assert.assertEquals(1, result.size());

    }

    @Test
    public void largerTest() {
        String[][] requests = {
                {"Steven", "Will"}, {"Helen", "Caroline"}, {"Caroline", "Helen"},
                {"Cheryl", "Heidi"}, {"Will", "Steven"}, {"Heidi", "Caroline"}};
        HashSet<Pair<String,String>> expected = new HashSet<Pair<String,String>>();
        expected.add(new Pair("Steven", "Will"));
        expected.add(new Pair("Helen", "Caroline"));
        Set<Pair<String,String>> result = Question2.findMatches(requests);
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void noMatches() {
        String[][] requests = {
                {"Steven", "Will"}, {"Helen", "Caroline"}};
        HashSet<Pair<String,String>> expected = new HashSet<Pair<String,String>>();
        Set<Pair<String,String>> result = Question2.findMatches(requests);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void twoMatches() {
        String[][] requests = {
                {"Steven", "Will"}, {"Helen", "Caroline"}, {"Will", "Steven"}, {"Caroline", "Helen"}};
        HashSet<Pair<String,String>> expected = new HashSet<Pair<String,String>>();
        Set<Pair<String,String>> result = Question2.findMatches(requests);
        Assert.assertEquals(2, result.size());
    }
}
