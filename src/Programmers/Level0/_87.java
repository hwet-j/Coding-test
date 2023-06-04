package src.Programmers.Level0;


/*
n × n 크기의 이차원 배열 arr이 매개변수로 주어질 때,
arr이 다음을 만족하면 1을 아니라면 0을 return 하는 solution 함수를 작성해 주세요.

0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]
*/


public class _87 {
	public static void main(String[] args) {
		int[][] arr = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};
		int answer = 1;

		for (int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length;j++){
				if (i != j){
					if (arr[i][j] != arr[j][i]){
						answer = 0;
					}
				}
			}
		}


	}
}


