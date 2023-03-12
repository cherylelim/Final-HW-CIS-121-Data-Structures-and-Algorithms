import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>QUESTION 3: BUNNY HOP</h1>
 * <p/>
 *
 * Class to implement the algorithm to find the minimum number of hops a bunny rabbit
 * must make to navigate from the bottom right corner to the top left corner of the city.
 * <p/>
 *
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question3 {

    /**
     * Returns the minimum number of hops needed for the bunny rabbit to make its way from the
     * bottom right corner to the top left corner given the hopping constraints in the writeup,
     * or -1 if a path does not exist.
     *
     * @param city an n x n 2d-array representing the city where each entry is a positive integer
     *             which defines how many cells the bunny can hop up or to the left when that
     *             entry is reached.
     * @return the minimum number of hops the bunny needs to make, or -1 if there is no 
     *         possible path
     * 
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static int getMinimumNumberOfHops(int[][] city) {

        int n = city.length;

        //convert coordinate to vertex:
        //int number = (y * n) + x;
        //convert vertex to coordinate:
        //int y = number/n;
        //int x = number - (y * n);

        //Create adjacency list
        LinkedList<Integer>[] adjList = new LinkedList[n * n];

        for (int i = 0; i < n * n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int x = 0; x < city.length; x++) {
            for (int y = 0; y < city[0].length; y++) {
                int hops = city[y][x];
                int number = (y * n) + x;
                //up
                if (y - hops >= 0 && number != 0) {
                    adjList[number].add(((y - hops) * n) + x);
                }
                //left
                if (x - hops >= 0 && number != 0) {
                    adjList[number].add((y * n) + (x - hops));
                }
            }
        }

        //bfs

        List<Integer> path = new ArrayList<Integer>();

        int source = ((n - 1) * n) + (n - 1);

        boolean[] discovered = new boolean[n * n];
        int[] parent = new int[n * n];

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        discovered[source] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (Integer u : adjList[v]) {
                if (!discovered[u]) {
                    discovered[u] = true;
                    q.add(u);
                    parent[u] = v;
                    if (u == 0) {
                        while (u != source) {
                            path.add(u);
                            u = parent[u];
                        }
                        return path.size();
                    }
                }
            }
        }

        return -1;
    }

}