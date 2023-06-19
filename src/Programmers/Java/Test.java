package src.Programmers.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args){
        double[] array = {0.001095, 5.1E-1,  0.591914, 5.1E-6};

        // Double[]로 변환
        Double[] boxedArray = Arrays.stream(array).boxed().toArray(Double[]::new);

        // 내림차순으로 정렬
        Arrays.sort(boxedArray, Comparator.reverseOrder());

        // 정렬된 배열 출력
        System.out.println(Arrays.toString(boxedArray));

        if (array[3] >= array[0]){
            System.out.println("ㅇㅇ?");
        } else if  (array[3] < array[0]){
            System.out.println("nn");
        }

    }
}
