package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class BucketSort extends IArraySort {
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);

        int buctetSize = 3;
        int minValue = arr[0], maxValue = arr[0];
        for (int v : arr) {
            if (v > maxValue) {
                maxValue = v;
            }
            if (v < minValue) {
                minValue = v;
            }
        }
        int count = (maxValue - minValue) / buctetSize + 1;
        int[][] bucketCount = new int[count][0];
        for (int i = 0; i < n; i++) {
            int key = (arr[i] - minValue) / buctetSize;
            bucketCount[key] = Arrays.copyOf(bucketCount[key], bucketCount[key].length + 1);
            bucketCount[key][bucketCount[key].length-1] = arr[i];
        }
        for (int[] bucket : bucketCount) {
            for (int i = 1; i < bucket.length; i++) {
                int temp = bucket[i];
                int j = i;
                while (j - 1 >= 0 && arr[j-1] > temp) {
                    arr[j] = arr[--j];
                }
            }
        }
        int pos = 0;
        for (int[] bucket : bucketCount) {
            for (int v : bucket) {
                arr[pos++] = v;
            }
        }
        return arr;
    }

    @Test
    public void test() {
        int[] sourceArray = {87,45,78,32,17,65,53,9,122};
        System.out.println(Arrays.toString(sort(sourceArray)));
    }
}
