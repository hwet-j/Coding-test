package src.Programmers.Java.Level1;


import java.util.Arrays;
import java.util.Comparator;

public class _22실패율2 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        // 스테이지별 실패율 계산
        double[] failRate = new double[N];

        // 스테이지별 도전자 수 계산 N번째 이후에는 성공으로 통일되니 몇개의 스테이지든 N+1개의 데이터만 필요
        int[] challengers_cnt = new int[N + 1];
        for (int stage : stages) {
            if (stage <= N) {
                challengers_cnt[stage]++;
            }
        }
        System.out.println(Arrays.toString(challengers_cnt));

        // 스테이지별 실패율 계산
        int total_challengers = stages.length;
        for (int i = 1; i <= N; i++) {
            if (total_challengers != 0) {
                // 스테이지별 계산이지만, 배열의 index는 0부터 이므로 -1
                failRate[i - 1] = (double) challengers_cnt[i] / total_challengers;
                // 앞 스테이지부터 확인하며, 실패한 인원은 그 이후 스테이지에 도전하지 못함.
                total_challengers -= challengers_cnt[i];
            } else {
                // 목표 스테이지에 도달전에 전부 실패하면 도전자가 없으므로 0
                failRate[i - 1] = 0;
            }
        }


        // 실패율을 기준으로 스테이지 정렬
        Integer[] answer = new Integer[N];
        for (int i = 0; i < N; i++) {
            answer[i] = i + 1;
        }
        Arrays.sort(answer, (a, b) -> Double.compare(failRate[b - 1], failRate[a - 1]));

        System.out.println(Arrays.toString(answer));


    }
}


/*
Arrays.sort(answer, (a, b) -> Double.compare(failRate[b - 1], failRate[a - 1]));
의 의미

Array.sort()는 배열을 정렬하는 메서드이며 그 대상은 answer이다.

(a, b) -> Double.compare(failRate[b - 1], failRate[a - 1])
는 비교로직을 나타내는 람다식입니다.

5.51E-6과 0.000911 와 같은 숫자를 정확하게 비교하기 위해서는 Double.compare을 사용하여 비교 가능하며 순서를 결정할 수 있다.

failRate[b - 1] 와 failRate[a - 1] 는 b, a번째 스테이지의 실패율을 나타낸다.

failRate[b - 1] 가 failRate[a - 1] 보다 작으면 음수
failRate[b - 1] 가 failRate[a - 1] 보다 크면 양수
failRate[b - 1] 가 failRate[a - 1] 와 같으면 0을 반환하면서 정렬함..

인터넷에서 찾아본 내림차순 방법인데 완벽히 이해는 못했다.

이전 문제풀이에서 그냥 sort를 사용하면 안된다는것까지는 이해를 했지만 저 람다식으로 인해서 정렬이 어떻게 되는지 모르겠다..

*/