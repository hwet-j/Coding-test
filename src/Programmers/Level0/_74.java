package src.Programmers.Level0;


/*
정수 배열 arr과 delete_list가 있습니다.
 arr의 원소 중 delete_list의 원소를 모두 삭제하고
 남은 원소들은 기존의 arr에 있던 순서를 유지한 배열을
 return 하는 solution 함수를 작성해 주세요.
*/

import java.util.Arrays;

public class _74 {
	public static void main(String[] args) {
		int[] arr = {293, 1000, 395, 678, 94};
		int[] delete_list = {94, 777, 104, 1000, 1, 12};
		int block = 0;
		int cnt = 0;
		int[] answer = new int[arr.length];

		for (int i=0; i<arr.length; i++){
			block = 0;
			for(int j=0; j<delete_list.length;j++){
				if (arr[i] == delete_list[j]){
					block = -1;
					break;
				}
			}
			if (block == 0){
				answer[cnt++] = arr[i];
			}
		}
		answer = Arrays.copyOf(answer, cnt);
		System.out.println(Arrays.toString(answer));
	}
}


