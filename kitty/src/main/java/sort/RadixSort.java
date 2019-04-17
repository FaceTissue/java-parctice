package sort;

import org.junit.Test;

import java.util.Arrays;

public class RadixSort extends IArraySort {
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);

        int maxValue = arr[0];
        for (int v : arr) {
            if (v > maxValue) maxValue = v;
        }

        int numLen = 0;
        while (maxValue > 0) {
            numLen++;
            maxValue /= 10;
        }

        for (int i = 0; i < numLen; i++) {
            int[][] bucket = new int[10 * 2][0];
            for (int j = 0; j < n; j++) {
                int m = i == 0 ? 1 : 10 * i;
                int key = arr[j] / m % 10 + 10;
                bucket[key] = Arrays.copyOf(bucket[key], bucket[key].length + 1);
                bucket[key][bucket[key].length - 1] = arr[j];
            }
            int k = 0;
            for (int[] nums : bucket) {
                for (int num : nums) {
                    arr[k++] = num;
                }
            }
        }

        return arr;
    }

    @Test
    public void test() {
        int[] sourceArray = {87,45,78,32,17,65,53,9,122,-20};
        System.out.println(Arrays.toString(sort(sourceArray)));
    }
}
