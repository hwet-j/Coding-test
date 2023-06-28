package src.Programmers.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args){
        int[] arr = {1,21,3,5,7,21};

        int maxindex = findMaxIndex(arr);
        System.out.println(Arrays.stream(arr).max());
        System.out.println(maxindex);


    }

    public static int findMaxIndex(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("배열이 비어 있습니다.");
        }

        int maxIndex = 0;
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
