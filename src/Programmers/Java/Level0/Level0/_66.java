package src.Programmers.Java.Level0.Level0;


/*
정수로 이루어진 리스트 num_list가 주어집니다.
num_list에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은
리스트를 return하도록 solution 함수를 완성해주세요.
*/

import java.util.Arrays;

public class _66 {
	public static void main(String[] args) {
		int[] num_list = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};
		Arrays.sort(num_list);

		System.out.println(Arrays.toString(num_list));
		int[] answer = new int[num_list.length - 5];
		answer = Arrays.copyOfRange(num_list, 5, num_list.length);
		System.out.println(Arrays.toString(answer));
	}
}


