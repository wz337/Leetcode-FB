class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() < 1) {  //remember the corner cases
            return 0;
        }
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                } 
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
