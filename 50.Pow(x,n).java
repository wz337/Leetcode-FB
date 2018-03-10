//Time: O(lgn)
//Space: O(lgn)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            return pow(1 / x, -n);
        } else {
            return pow(x, n);
        }
    }
    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = pow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
