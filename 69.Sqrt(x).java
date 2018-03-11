//Time: O(lgx)
class Solution {
    public int mySqrt(int x) {
        if (x <= 0){
            return 0;
        }
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
