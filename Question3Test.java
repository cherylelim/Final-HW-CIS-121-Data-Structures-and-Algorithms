import org.junit.Assert;
import org.junit.Test;

public class Question3Test {

    @Test
    public void givenTest() {
        int[][] city = {{1, 6, 2},
                        {1, 6, 4},
                        {1, 9, 2} };

        int result = Question3.getMinimumNumberOfHops(city);
        Assert.assertEquals(2,result);
    }

    @Test
    public void shortestPathTest() {
        int[][] city = {{1, 1, 1},
                        {6, 6, 4},
                        {2, 9, 2} };

        int result = Question3.getMinimumNumberOfHops(city);
        Assert.assertEquals(2,result);
    }

    @Test
    public void overlappingPathTest() {
        int[][] city = {{0, 3, 2},
                        {1, 1, 1},
                        {5, 4, 1} };

        int result = Question3.getMinimumNumberOfHops(city);
        Assert.assertEquals(3, result);
    }

    @Test
    public void noPath() {
        int[][] city = {{1, 9, 8},
                        {3, 5, 9},
                        {5, 4, 5} };
        int result = Question3.getMinimumNumberOfHops(city);
        Assert.assertEquals(-1, result);
    }
}
