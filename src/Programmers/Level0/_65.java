package src.Programmers.Level0;


/*
정수로 이루어진 리스트 num_list가 주어집니다. num_list에서 가장 작은 5개의 수
를 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
*/

import java.util.Arrays;

public class _65 {
	public static void main(String[] args) {
		int[] num_list = {12, 4, 15, 46, 38, 1, 14};
		Arrays.sort(num_list);

		System.out.println(Arrays.toString(num_list));
		int[] answer = new int[5];
		answer = Arrays.copyOf(num_list, 5);

	}
}


