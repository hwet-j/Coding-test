package src.Programmers.Java.Level0.Level0;


/*
정수가 담긴 리스트 num_list가 주어질 때,
리스트의 길이가 11 이상이면 리스트에 있는
모든 원소의 합을 10 이하이면 모든 원소의
곱을 return하도록 solution 함수를 완성해주세요.
*/

public class _39 {
	public static void main(String[] args) {
		int[] num_list = {3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1};
		int answer = 0;
		if (num_list.length > 10){
			for (int i:num_list){
				answer += i;
			}
		} else {
			answer = 1;
			for (int i:num_list){
				answer *= i;
			}
		}


		System.out.println(answer);
	}
}


