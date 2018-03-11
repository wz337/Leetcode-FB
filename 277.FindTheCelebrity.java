/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n < 2) {
            return -1;
        }
        int celebrity = 0;
        for (int i = 0; i < n; i++) {
            //if one knows other, he or she won't be the celebrity.
            //if one doesn't know other, then the other people won't be the celebrity, because everyone knows the celebrity.
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (celebrity != i && (!knows(i, celebrity) || knows(celebrity, i))) {
                return -1;
            }
        }
        return celebrity;
    }
}
