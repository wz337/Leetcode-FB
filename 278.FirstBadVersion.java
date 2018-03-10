/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/*
Time: O(lgn)
Space: O(1)
Test Case: 
1 2 3 4 (2, 3, 4 are both bad version)
round 1: left = 1, right = 4, mid = 2, isBadVersion(2) = true, right = mid = 2
round 2: while loop condition cannot be satisfied
*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }
        int left = 1; //n versions [1, 2, ..., n]
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }
        return right;
    }
}
