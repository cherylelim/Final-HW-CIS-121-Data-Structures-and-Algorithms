import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>QUESTION 4: AIRPORT CODE GAME -- OFF BY ONE!</h1>
 * <p/>
 *
 * Class to implement the algorithm to find the smallest chain between two 3 letter
 * airport codes.
 * <p/>
 *
 * See description of problem and example in the write-up.
 *
 * @author bursztyn
 */
public class Question4 {

    /**
     * Solves the "Airport Code Change" game. See complete problem description above.
     * <p/>
     * 
     * You may assume that all codes contain only UPPERCASE alphabetic (A-Z) characters.
     *
     * @param code1 the 3 letter airport code you want to start from
     * @param code2 the 3 letter airport code you want to end at
     * @param codes the set of 3 letter airport codes you can use to get from code1 -> code2
     * @return the smallest chain of airport codes to get from {@code code1 -> code2}. {@code code1}
     *         should be the first element, and {@code code2} should be the last. If no valid
     *         solution exists, return {@code null}. If {@code code1.equals(code2)}, return an empty
     *         list.
     *
     * @implSpec you may assume that all inputs are valid. Do not throw any exceptions.
     */
    public static List<String> getSmallestChain(String code1, String code2, Set<String> codes) {
        Object[] codesArray = codes.toArray();
        LinkedList<String> result = new LinkedList<String>();

        //if codes are the same
        if (code1.equals(code2)) {
            return result;
        }

        //Create an adjacency list
        //Add strings to the adjacency list if they are one letter apart
        HashMap<String, LinkedList<String>> adjList = new HashMap<String, LinkedList<String>>();

        for (int i = 0; i < codesArray.length; i++) {
            for (int j = i + 1; j < codesArray.length; j++) {
                String c1 = (String) codesArray[i];
                String c2 = (String) codesArray[j];
                if (oneCharacterApart(c1,c2)) {
                    if (adjList.containsKey(c1)) {
                        adjList.get(c1).add(c2);
                    } else {
                        adjList.put(c1, new LinkedList<String>());
                        adjList.get(c1).add(c2);
                    }
                    if (adjList.containsKey(c2)) {
                        adjList.get(c2).add(c1);
                    } else {
                        adjList.put(c2, new LinkedList<String>());
                        adjList.get(c2).add(c1);
                    }

                }
            }
        }

        //bfs
        HashMap<String, Boolean> discovered = new HashMap<String, Boolean>();
        for (int i = 0; i < codesArray.length; i++) {
            discovered.put((String) codesArray[i], false);
        }

        HashMap<String, String> parent = new HashMap<String, String>();

        Queue<String> q = new LinkedList<String>();
        q.add(code1);
        discovered.replace(code1, true);

        while (!q.isEmpty()) {
            String v = q.poll();
            for (String u : adjList.get(v)) {
                if (!discovered.get(u)) {
                    discovered.replace(u, true);
                    q.add(u);
                    if (parent.containsKey(u)) {
                        parent.replace(u, v);
                    } else {
                        parent.put(u,v);
                    }
                    if (u.equals(code2)) {
                        while (!u.equals(code1)) {
                            result.addFirst(u);
                            u = parent.get(u);
                        }
                        result.addFirst(u);
                        return result;
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result = null;
        }
        return result;
    }

    private static boolean oneCharacterApart(String s1, String s2) {
        int countDifferences = 0;
        for (int i = 0; i < 3; i++) {
            if (!s1.substring(i, i + 1).equals(s2.substring(i, i + 1))) {
                countDifferences++;
            }
        }
        if (countDifferences == 1) {
            return true;
        }
        return false;
    }
}