package techQuestions;

/*
Purpose: In a town, there are N people labelled from 1 to N.
There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

1) The town judge trusts nobody.
2) Everybody (except for the town judge) trusts the town judge.
3) There is exactly one person that satisfies properties 1 and 2.

You are given trust, an array of pairs trust[i] = [a, b]
representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the
label of the town judge.  Otherwise, return -1.

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

Author: Erich Meissner
Date: 5/10/20
Time: 1:12 PM
 */

import java.util.HashSet;
import java.util.Set;

public class FindTownJudge {
    public static void main(String[] args) {
        int[][] trust = {};
        System.out.println(findJudge(1, trust));
    }

    public static int findJudge(int N, int[][] trust) {
        // outdegrees is number of people this candidate trusts
        // indegrees is number of people that trust this candidate
        if (trust.length < N-1) {
            return -1;
        }
        int[] trusted = new int[N+1];
        int[] trusts = new int[N+1];
        for (int[] relation: trust) {
            trusts[relation[0]] = trusts[relation[0]] + 1;
            trusted[relation[1]] = trusted[relation[1]] + 1;
        }
        for (int i = 0; i <= N; i++) {
            if (trusts[i] == 0 && trusted[i] == N - 1) {
                return i;
            }
        }
        return -1;
//        if (trust == null || trust.length == ) {
//            return N;
//        }
//        if (trust.length == 0) {
//            return -1;
//        } else if (trust.length == 1) {
//            return trust[0][1];
//        }
//        // brute force? for each candidate for judge, traverse entire
//        // trust matrix to see if they are trusted by all others
//        Set<Integer> candidates = new HashSet<Integer>();
//        Set<Integer> citizens = new HashSet<Integer>();
//        for (int i = 0; i < trust.length; i++) {
//            citizens.add(trust[i][0]);
//        }
////        System.out.println(citizens.toString());
//        for (int i = 0; i < trust.length; i++) {
//            int candidate = trust[i][1];
//            // if we have already checked this candidate,
//            // then continue...else add it to set
//            if (candidates.contains(candidate)) {
//                continue;
//            } else {
//                candidates.add(candidate);
//            }
////            System.out.println(candidate);
//            Set<Integer> judge = new HashSet<Integer>();
//            judge.add(trust[i][0]);
//            for (int j = i+1; j < trust.length; j++) {
//                if (trust[j][1] == candidate) {
//                    judge.add(trust[j][0]);
//                }
//            }
//            if (judge.containsAll(citizens)) {
//                return candidate;
//            }
//        }
//        return -1;
    }
}
