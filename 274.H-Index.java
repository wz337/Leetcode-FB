//Time: O(n)
//Space: O(n)
//Use the idea of counting sort
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length < 1) {
            return 0;
        }
        int n = citations.length;
        //i: the number of citations, count[i]: how many times do we have exactly ith number of citation
        int[] count = new int[n + 1];
        
        for (int i : citations) {
            if (i <= n) {
                count[i]++;
            } else {    
                //If we only have 5 articles, we don't care about if an article have been cited 100 times. 
                //e.g. [100, 98, 0, 5, 1] We will never have an h index bigger than 5 in this case. 
                count[n]++;
            }
        }
        
        int sum = 0;    //the number of articles that have at least i number of citations (i, i + 1, i + 2...)
        for (int i = n; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
