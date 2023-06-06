package src.Programmers.Java.Level0;


/*
이차원 정수 배열 arr이 매개변수로 주어집니다. arr의 행의 수가 더
많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고,
열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한
이차원 배열을 return 하는 solution 함수를 작성해 주세요.
*/


public class _88 {
	public static void main(String[] args) {
		int[][] arr = {{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}};
		int width = arr[0].length;
		int height = arr.length;

		int setSize = (height > width ? height : width);

		int[][] answer = new int[setSize][setSize];

		for(int i=0;i<height; i++) {
			for (int j=0;j<width; j++){
				answer[i][j] = arr[i][j];
			}
		}

	}
}


