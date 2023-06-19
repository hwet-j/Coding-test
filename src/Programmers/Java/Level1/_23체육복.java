package src.Programmers.Java.Level1;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _23체육복 {
    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        List<Integer> lost_list = Arrays.stream(lost)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());

        List<Integer> reserve_list = Arrays.stream(reserve)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());

        System.out.println(lost_list);
        System.out.println(reserve_list);

        int[] have_student = new int[n];

        for(int i=1; i<=n;i++){
            if(reserve_list.contains(i)){
                if (lost_list.contains(i)){
                    have_student[i-1] = 1;
                } else {
                    have_student[i-1] = 2;
                }
            } else if(lost_list.contains(i)){
                have_student[i-1] = 0;
            } else {
                have_student[i-1] = 1;
            }
        }
        System.out.println(Arrays.toString(have_student));

        for (int i=0; i<n; i++) {
            if (i == 0) {
                if (have_student[i] == 0) {
                    if (have_student[i + 1] == 2) {
                        have_student[i]++;
                        have_student[i + 1]--;
                    }
                }
            } else if (i == n - 1) {
                if (have_student[i] == 0) {
                    if (have_student[i - 1] == 2) {
                        have_student[i]++;
                        have_student[i - 1]--;
                    }
                }
            } else {
                if (have_student[i] == 0) {
                    if (have_student[i - 1] == 2) {
                        have_student[i]++;
                        have_student[i - 1]--;
                    } else if (have_student[i + 1] == 2) {
                        have_student[i]++;
                        have_student[i + 1]--;
                    }
                }
            }
        }

        int answer  = 0;
        for (int i=0; i<n; i++){
            if(have_student[i] != 0){
                answer ++ ;
            }
        }
        System.out.println(answer);

    }
}


/*

*/