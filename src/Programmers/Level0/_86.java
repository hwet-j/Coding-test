package src.Programmers.Level0;


/*
양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스
[0][0]부터 시계방향 나선형으로 배치한 이차원 배열을
return 하는 solution 함수를 작성해 주세요.
*/

import java.util.Arrays;

public class _86 {
	public static void main(String[] args) {
		int n = 4;
		int[][] answer = new int[n][n];
		
		// 입력값
		int num = 1;

		// 4개의 기준에 Line을 찾기위해 변수 설정
		int cnt1 = 0;

		// 입력값이 n제곱을 넘으면 정지
		while(num < n*n+1) {
			// 좌 -> 우
			for (int i = cnt1; i < n - cnt1; i++) {
				answer[cnt1][i] = num++;
			}
			// 상 -> 하
			for (int i = cnt1 + 1; i < n - cnt1; i++) {
				answer[i][n - (cnt1 + 1)] = num++;
			}
			// 우 -> 좌
			for (int i = n - (cnt1 + 2); i >= cnt1; i--) {
				answer[n - (cnt1 + 1)][i] = num++;
			}
			// 하 -> 상
			for (int i = n - (cnt1 + 2); i > cnt1; i--) {
				answer[i][cnt1] = num++;
			}
			cnt1++;		// 1회 회전 완료
		}
		for (int[] ans : answer) {
			System.out.println(Arrays.toString(ans));
		}

	}
}


