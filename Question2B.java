
import java.util.*;

/**
 * <h1>QUESTION 2: ROOMMATE MATCHING</h1>
 * <p/>
 *
 * Class to implement the algorithm to select roommates from a 2d-array of pairs.
 * <p/>
 *
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question2B {

    public static int binarySearch(String[][] requests, String s) {
        int l = 0 ;
        int r = requests.length - 1;
        while (l < r) {
            int m = (l + r) / 2;

            if (s.compareTo(requests[m][0]) < 0) {
                r = m - 1;
            } else if (s.compareTo(requests[m][0]) > 0) {
                l = m + 1;
            } else {
                return m;
            }
        }
        if (s.equals(requests[l][0])) {
            return l;
        } else {
            return -1;
        }
    }

    /**
     * Returns the set of roommates who mutually requested each other.
     *
     * @param requests the 2d-array of pairs of requests of the form (student, requested roommate).
     *                 Note: a student cannot request themself. 
     * @return a set of pairs of roommates who mutually requested each other
     * 
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static Set<Pair<String, String>> findMatches(String[][] requests) {
        Arrays.sort(requests, new Comparator<String[]>() {
            public int compare(String[] r1, String[] r2) {
                return r1[0].compareTo(r2[0]);
            }
        });


        Set<Pair<String, String>> answer = new HashSet<>();

        for (int i = 0; i < requests.length; i++) {
            String origin = requests[i][0];
            String destin = requests[i][1];

            int index = binarySearch(requests, destin);
            if (index == -1) {
                continue;
            }
            if (index > i && requests[index][1].equals(origin)) {
                answer.add(new Pair(origin, destin));
            }
        }
        return answer;

    }
}
