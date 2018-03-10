class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int XOR = x^y;
        while (XOR > 0) {
            if ((XOR & 1) == 1) {
                res++;
            }
            XOR >>= 1;
        } 
        return res;
    }
}
