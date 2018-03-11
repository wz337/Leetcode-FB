/*
res = "1" count = 0 c = '1', res.length() = 1
for loop j = 0, if: count++ => count = 1;
         j = 1, else: sb = "11" 
         res = "11"
res = "11", count = 0, c = '1', res.length() = 2
for loop j = 0, if: count++ => count = 1;
         j = 1, if: count++ => count = 2;
         j = 2, else: sb = "21"
         res = "21"
res = "21", count = 0, c = '2', res.length() = 2
for loop j = 0, if: count++ => count = 1;
         j = 1, else: sb = "12", c = '1', count = 1
         j = 2, else: sb = "11" 
         res = "1211"
res = "1211", count = 0, c = '1', res.length() = 4
for loop j = 0, if: count++ => count = 1
         j = 1, else: sb = "11", c = '2', count = 1
         j = 2, else: sb = "1112", c = '1', count = 1
         j = 3, if: count++ => count = 2
         j = 4: else: sb = "111221"
         res = "111221"
*/
class Solution {
    public String countAndSay(int n) {
        int i = 1;
        String res = "1";
        while (i < n) { //i is in charge of taking care the step towards n
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            for (int j = 0; j <= res.length(); j++) { //j is the index of current res
                if (j != res.length() && res.charAt(j) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    if (j != res.length()) {
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            res = sb.toString();
            i++;
        }
        return res;
    }
}
