package src.Programmers.Level0;


/*
1부터 6까지 숫자가 적힌 주사위가 두 개 있습니다.
두 주사위를 굴렸을 때 나온 숫자를 각각 a, b라고 했을 때 얻는 점수는 다음과 같습니다.

a와 b가 모두 홀수라면 a2 + b2 점을 얻습니다.
a와 b 중 하나만 홀수라면 2 × (a + b) 점을 얻습니다.
a와 b 모두 홀수가 아니라면 |a - b| 점을 얻습니다.

두 정수 a와 b가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
*/

public class _79 {
	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		int answer = 0;
		int cnt = 0;
		if (a % 2 == 0){
			cnt++;
		}
		if (b % 2 == 0){
			cnt++;
		}

		if(cnt == 0){
			answer = a * a + b * b;
		} else if (cnt == 1){
			answer = 2 * (a + b);
		} else {
			if (a > b){
				answer = a - b;
			} else {
				answer = b - a;
			}

		}


	}
}


