import java.util.List;
import java.util.LinkedList;

/**
 * <h1>QUESTION 5: ODD SIZED FAMILY TREES</h1>
 * <p/>
 *
 * Class to implement the algorithm to determine the number of odd sized sub-trees in a given
 * family tree.
 * <p/>
 *
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question5 {

    /**
     * Returns the number of odd sized sub-trees in a given family tree.
     *
     * @param family an adjacency list of the family tree
     * @param root the favorite number of the root of the family tree
     * @return the number of odd sized sub-trees
     * 
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static int getNumberOfOddSubtrees(List<List<Integer>> family, int root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        int h = recurOddSubtrees(family, root, result);
        return result.size();
    }

    private static int recurOddSubtrees(List<List<Integer>> family, int node,
                                        LinkedList<Integer> oddSubtrees) {
        if (family.get(node).size() == 0) {
            oddSubtrees.add(node);
            return 1;
        }
        int count = 0;
        for (Integer child : family.get(node)) {
            count += recurOddSubtrees(family, child, oddSubtrees);
        }
        count++;
        if (count % 2 == 1) {
            oddSubtrees.add(node);
        }
        return count;
    }
}