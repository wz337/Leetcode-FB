class Solution {
    String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num % 1000 != 0) {
                sb.insert(0, helper(num % 1000) + thousands[i] + " ");
            }
            i++;
            num /= 1000;
        }
        return sb.toString().trim();
    }
    private String helper(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 20) {
            return less20[num % 20] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return less20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
