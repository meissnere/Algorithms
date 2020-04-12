package techQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Given the array queries of positive integers between 1 and m,
//you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:
//        -- In the beginning, you have the permutation P=[1,2,3,...,m].
//        -- For the current i, find the position of queries[i] in the
//        permutation P (indexing from 0) and then move this at the beginning of the
//        permutation P. Notice that the position of queries[i] in P is the result for queries[i].
//Return an array containing the result for the given queries.
public class QueriesPermutationKey {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] queries = {7,5,5,8,3};
        int m = 8;

        System.out.println(Arrays.toString(processQueries(queries, m)));
    }

    public static int[] processQueries(int[] queries, int m) {
        List<Integer> P = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            P.add(i-1, i);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int P_index = P.indexOf(queries[i]);
            res[i] = P_index;
            while (P_index > 0) {
                Collections.swap(P, P_index-1, P_index);
                P_index--;
            }
        }

        return res;
    }
}
