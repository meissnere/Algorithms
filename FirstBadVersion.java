package techQuestions;

/*
Purpose: You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check. Since each version
is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.


Author: Erich Meissner
Date: 5/1/2020
Time: 11:38 PM
*/

public class FirstBadVersion {
    // we are tasked to minimize calls to isBadVersion API
    // I think we can do this with Binary search 0(log N)

    public static void main(String[] args) {
        boolean[] versions = {false, true};
        int n = 5;
        System.out.println(firstBadVersion(n, versions));
    }

    public static int firstBadVersion(int n, boolean[] versions) {
        //         if (n == 0) {
//             return 0;
//         }
//         if (n == 1 && isBadVersion(1) == true) {

//         }
        int start = 1;
        int end = n;
        //we're doing binary search!
        int midpoint = 0;
        // this condition is quite clever:
        // once we catch up to the end point,
        // we know we have found our first "true" value
        while (start < end) {
            midpoint = start + (end - start) / 2;
            if (versions[midpoint] == false) {
                start = midpoint + 1;
                // end stays at its current end
            } else {
                // true! let's look left more
                end = midpoint;
            }
        }
        return start;
    }

}
