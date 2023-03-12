import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class Question1Test {

    @Test
    public void givenTest() {
        int numFlights = 4;
        int[][] conditions = {{3,2}, {1,2}, {0,3}, {0,1}};
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        result1.add(2);
        result1.add(3);
        result1.add(1);
        result1.add(0);
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result2.add(2);
        result2.add(1);
        result2.add(3);
        result2.add(0);
        List<Integer> result = Question1.getFlightDepartureSchedule(numFlights, conditions);
        Assert.assertTrue(result.equals(result1) || result.equals(result2));

    }

    @Test
    public void notPossible() {
        int numFlights = 3;
        int[][] conditions = {{1,0}, {2,1}, {0,2}};
        List<Integer> result = Question1.getFlightDepartureSchedule(numFlights, conditions);
        List<Integer> expected = new ArrayList<>();
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void notPossible2() {
        int numFlights = 4;
        int[][] conditions = {{1,0}, {2,1}, {3,2}, {1,3}};
        List<Integer> result = Question1.getFlightDepartureSchedule(numFlights, conditions);
        List<Integer> expected = new ArrayList<>();
        Assert.assertTrue(result.equals(expected));
    }


}
