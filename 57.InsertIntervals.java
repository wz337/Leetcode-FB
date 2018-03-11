/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//Time: O(n)
//Space: O(n)
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int index = 0;
        //Find the point to insert.
        //As the list is sorted to start with, we can easily find the point of insertion.
        //No need to sort.
        while (index < intervals.size() && intervals.get(index).start < newInterval.start) {
            index++;
        }
        intervals.add(index, newInterval);
        
        //Merge Intervals
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
