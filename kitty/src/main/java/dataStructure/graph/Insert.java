package dataStructure.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int idx = 0;
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            res.add(intervals[idx++]);
        }
        int[] tmp = new int[]{newInterval[0], newInterval[1]};
        while (idx < intervals.length && tmp[1] >= intervals[idx][0]) {
            tmp[0] = Math.min(tmp[0], intervals[idx][0]);
            tmp[1] = Math.max(tmp[1], intervals[idx][1]);
            idx++;
        }
        res.add(tmp);
        while (idx < intervals.length) {
            res.add(intervals[idx++]);
        }
        return res.toArray(new int[0][]);
    }

    @Test
    public void insertTest() {
        for (int[] interval : insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
