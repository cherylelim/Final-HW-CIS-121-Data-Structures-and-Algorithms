import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>QUESTION 1: FLIGHT SCHEDULES</h1>
 * <p/>
 *
 * Class to implement the algorithm to determine a possible flight schedule given the conditions.
 * <p/>
 *
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question1 {

    /**
     * Given the number of flights to schedule and conditions for departure, returns one possible
     * departure schedule.
     *
     * @param numFlights the number of flights waiting to take off
     * @param conditions the list of condition pairs (no duplicate pairs may exist)
     * @return one possible valid flight departure ordering, or an empty list if none exists
     * 
     * @implSpec you may assume that input is valid (well formatted, mx2 2d-array) and non-null.
     * Do not throw any exceptions.
     */
    public static List<Integer> getFlightDepartureSchedule(int numFlights, int[][] conditions) {
        //Create an adjacency list (array of lists)
        LinkedList<Integer>[] adjList = new LinkedList[numFlights];
        for (int i = 0; i < numFlights; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < conditions.length; i++) {
            int flightBefore = conditions[i][1];
            int flightAfter = conditions[i][0];
            adjList[flightBefore].add(flightAfter);
        }
        //Kahn's: topological sorting
        List<Integer> result = new LinkedList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int[] indegrees = new int[numFlights];

        //for each flight, compute the in-degree
        for (int i = 0; i < numFlights; i++) {
            for (Integer j : adjList[i]) {
                indegrees[j] = indegrees[j] + 1;
            }
        }

        //initially populate queue
        for (int i = 0; i < numFlights; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            result.add(v);
            for (Integer u : adjList[v]) {
                indegrees[u] = indegrees[u] - 1;
                if (indegrees[u] == 0) {
                    q.add(u);
                }
            }
        }
        //if not possible
        if (result.size() != numFlights) {
            return new LinkedList<Integer>();
        }
        return result;

    }
}
