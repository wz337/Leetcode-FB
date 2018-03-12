//Time: O(m*n)
//Space: O(m+n)
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() < 1 || num2.length() < 1) {
            return "";
        }
        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];
        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int i1 = i + j;
                int i2 = i + j + 1;
                int sum = prod + result[i2];
                result[i2] = sum % 10;
                result[i1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            if (!(i == 0 && sb.length() == 0)) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
