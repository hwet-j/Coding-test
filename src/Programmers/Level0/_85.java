package src.Programmers.Level0;


/*
알파벳 소문자로 이루어진 문자열 myString이 주어집니다.
알파벳 순서에서 "l"보다 앞서는 모든 문자를 "l"로 바꾼
문자열을 return 하는 solution 함수를 완성해 주세요.
*/

public class _85 {
	public static void main(String[] args) {
		int n = 3;
		int[][] answer = new int[n][n];

		for (int i=0; i<n;i++){
			for (int j=0; j<n; j++){
				if(i == j){
					answer[i][j] = 1;
				} else {
					answer[i][j] = 0;
				}
			}
		}

	}
}


