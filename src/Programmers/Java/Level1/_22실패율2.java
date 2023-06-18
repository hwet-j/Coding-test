package src.Programmers.Java.Level1;


import java.util.Arrays;

public class _22실패율2 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        double[] result = new double[N];
        int cnt = 0;
        int length_cnt = stages.length;
        
        for (int i=1; i<N+1; i++){
            for(int j=0; j< stages.length; j++){
                if(i == stages[j]){
                    cnt++;
                }
            }
            // 도전자중 실패자를 파악
            result[i-1] = Math.round(cnt * 100000000 / length_cnt ) / 100000000.0;
            length_cnt -= cnt;

            cnt = 0;
        }

        double[] result2 = Arrays.copyOf(result ,N);
        Arrays.sort(result2);
        // 실패율에 따른 순서
        int[] answer  = new int[N];

        // 각 스테이지의 번호를 실패율의 내림차순으로 정렬
        for (int i=N-1; i>=0; i--){
            for (int j=0; j<N; j++){
                if(result2[i] == result[j]){
                    answer[N-1-i] = j+1;
                    result[j] = -1;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}


/*
처음에  Array.sort 로 정렬해 문제를 풀이하려했으나, 동일한 값이 나왔을 경우 비교하여 순위를 결정하는 방법이 어려워


*/