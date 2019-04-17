package sort;

import org.junit.Test;

import java.util.Arrays;

public class CountingSort extends IArraySort {
    @Override
    int[] sort(int[] sourceArray) {
        int n = sourceArray.length;
        int[] arr = Arrays.copyOf(sourceArray, n);

        int maxValue = arr[0];
        for (int v : arr) {
            if (v > maxValue) {
                maxValue = v;
            }
        }

        int[] bucket = new int[maxValue+1];
        for (int v : arr) {
            bucket[v]++;
        }
        int pos = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[pos++] = i;
                bucket[i]--;
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
