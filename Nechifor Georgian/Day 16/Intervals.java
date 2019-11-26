package cw;
import java.util.HashSet;
import java.util.Set;
public class Interval {

   public static int sumIntervals(int[][] intervals) {
        int len = 0;
        if(intervals == null || intervals.length == 0) return 0; 
        Set<Integer> nrs = new HashSet<>();
        for(int i = 0; i < intervals.length; i++) {
            for(int j = intervals[i][0]; j < intervals[i][1]; j++) {
                nrs.add(j);
            }
        }
        //System.out.println(nrs);
        return nrs.size();
    }
}
