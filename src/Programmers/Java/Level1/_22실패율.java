package src.Programmers.Java.Level1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _22실패율 {
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
배열만을 사용하여 풀이하려 한 코드이다.

정답에 매우 근접 사실상 정답이나 마찬가지지만, 큰숫자로 나누게 될 경우

0.19029041591 를 넘어서 1.019E-19 와같은 형태가 되는데 이럴때 비교를 하게되면 0.19가 더욱 작은 값으로 인식하게 되어버리는 문제가 생긴다.

이런 문제는 Double.compare(number1, number2); 와같이 해결이 가능하지만 숫자 크기에 따라 정렬을

Array.sort로 했기 때문에 직접적인 사용이 불가능하다. 그렇기 때문에 하나씩 비교를하면서 나열을 하거나 다른 방식을 찾아봐야할것같다.


*/