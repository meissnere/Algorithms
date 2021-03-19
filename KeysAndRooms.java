/*
Purpose: There are N rooms and you start in room 0.  Each room has a distinct number
in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an
integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the
room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.

Author: Erich Meissner
Date: 3/19/21
Time: 5:42 PM
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(3);

        List<Integer> list4 = new ArrayList<Integer>();

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        System.out.println(canVisitAllRooms(lists));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int count = 1;
        while (stack.size() > 0)
            for (int k : rooms.get(stack.pop()))
                if (!vis[k]) {
                    stack.push(k);
                    vis[k] = true;
                    count++;
                }
        return rooms.size() == count;
    }
}
