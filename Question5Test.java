import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class Question5Test {

    @Test
    public void givenTest() {
        ArrayList<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < 7; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(3);
        adjList.get(1).add(2);
        adjList.get(1).add(4);
        adjList.get(1).add(5);
        adjList.get(3).add(6);

        int result = Question5.getNumberOfOddSubtrees(adjList, 0);
        Assert.assertEquals(5, result);
    }

    @Test
    public void largerTree() {
        ArrayList<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < 13; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(0).add(3);
        adjList.get(1).add(4);
        adjList.get(1).add(5);
        adjList.get(4).add(6);
        adjList.get(2).add(7);
        adjList.get(2).add(8);
        adjList.get(3).add(9);
        adjList.get(3).add(10);
        adjList.get(9).add(11);
        adjList.get(9).add(12);

        int result = Question5.getNumberOfOddSubtrees(adjList, 0);
        Assert.assertEquals(11, result);
    }
}
