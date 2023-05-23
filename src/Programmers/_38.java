package src.Programmers;


/*
문제에 오류가 있는 것 같아 정답을 확인하며 출제자의 의도대로 해석하여 풀이하였다.

정수가 있을 때, 짝수라면 반으로 나누고, 홀수라면 1을 뺀 뒤 반으로 나누면,
마지막엔 1이 됩니다. 예를 들어 10이 있다면 다음과 같은 과정으로 1이 됩니다.

10 / 2 = 5
(5 - 1) / 2= 2
2 / 2 = 1
위와 같이 3번의 나누기 연산으로 1이 되었습니다.

정수들이 담긴 리스트 num_list가 주어질 때, num_list의
모든 원소를 1로 만들기 위해서 필요한 나누기 연산의 횟수를
return하도록 solution 함수를 완성해주세요
*/

public class _38 {
	public static void main(String[] args) {
		int[] num_list = {12, 4, 15, 1, 14};
		int answer = 0;

		for(int i=0; i< num_list.length;i++){
			while (num_list[i] != 1){
				if(num_list[i] % 2 == 0){
					num_list[i] /= 2;
					answer++;
				} else {
					num_list[i] = (num_list[i]-1) / 2;
					answer++;
				}
			}
		}

		System.out.println(answer);

	}
}


