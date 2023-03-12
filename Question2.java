import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

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
public class Question2 {

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
        //O(nlogn)
        HashSet<Pair<String,String>> result = new HashSet<Pair<String,String>>();
        Arrays.sort(requests[0]);
        for (int i = 0; i < requests.length; i++) {
            String first = requests[i][0];
            String second = requests[i][1];
            if (second != null &&
                    binarySearchResult(requests, first, second, 0, requests.length - 1)) {
                result.add(new Pair(first,second));
            }
        }
        return result;
    }

    private static boolean binarySearchResult(String[][] requests, String first,
                                              String target, int low, int high) {
        if (high < low) {
            return false;
        }
        int mid = (low + high) / 2;
        if (requests[mid][1] != null && requests[mid][0].equals(target)) {
            if (requests[mid][1].equals(first)) {
                //remove in binarySearch
                requests[mid][1] = null;
                return true;
            }
            return false;
        } else if (requests[mid][0].compareTo(target) < 0) {
            return binarySearchResult(requests, first, target, mid + 1, high);
        }
        return binarySearchResult(requests, first, target, low, mid - 1);

    }
}
