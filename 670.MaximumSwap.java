//7236
//bucket:   e.g. 2736 -> 7236
//          index 0 1 2 3 4 5 6 7 8 9 
//                    0 2     3 1
class Solution {
    public int maximumSwap(int num) {
        if (num <= 0) {
            return 0;
        }
        char[] digits = Integer.toString(num).toCharArray();
        int[] lastIndex = new int[10];
        
        for (int i = 0; i < digits.length; i++) {
            lastIndex[digits[i] - '0'] = i;     //record the last apperance of a digit
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) { //the smallest digit we want to swap with digits[i] has to be at least 1 larger than the current digit
                if (lastIndex[j] > i) {
                    char temp = digits[i];  //record the current digit
                    digits[i] = digits[lastIndex[j]]; //swap the later index number with the current index
                    digits[lastIndex[j]] = temp;
                    return Integer.valueOf(new String(new String(digits)));
                }
            }
        }
        return num;
    }
}

// Intuition

// At each digit of the input number in order, if there is a larger digit that occurs later, we know that the best swap must occur with the digit we are currently considering.

// Algorithm

// We will compute \text{last[d] = i}last[d] = i, the index i of the last occurrence of digit d (if it exists).

// Afterwards, when scanning the number from left to right, if there is a larger digit in the future, we will swap it with the largest such digit; if there are multiple such digits, we will swap it with the one that occurs the latest.
