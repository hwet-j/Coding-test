package src.Programmers.Java.Level1;

// 1부터 number 까지 진행하며 시작은 1로 설정하고, 2이상에서 약수의 개수를 구해준다.
// k의 약수를 구할때, 자기 자신을 제외한 약수의 최대값은 k/2이다. 이를 참고해서 약수를 찾으면 계산 시간을 줄일 수 있다.
// for문을 k까지 전부 돌리게되면 시간초과로 문제풀이를 정답처리 할 수 없다.
// 또한, 약수의 개수가 limit을 초과하면 power로 수정한다.

public class _11기사단원의무기 {
    public static void main(String[] args){
        int number = 10;
        int limit = 3;
        int power = 2;
        int answer = 0;

        int cnt = 0;

        for (int i=1; i<number+1; i++){
            cnt = 1;
            if (i >= 2){
                for(int j=1; j<=i/2; j++){
                    if(i % j == 0){
                        cnt++;
                        if (cnt > limit){
                            cnt = power;
                            break;
                        }
                    }
                }
            }
            answer += cnt;
        }

        System.out.println(answer);

    }
}
