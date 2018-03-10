/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
| |   | | |
    |  | |  | |
*/
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int end = 0, room = 0;
        for (int start = 0; start < starts.length; start++) {
            if (starts[start] < ends[end]) {
                room++;
            } else {
                end++;
            }
        }
        return room;
    }
}
