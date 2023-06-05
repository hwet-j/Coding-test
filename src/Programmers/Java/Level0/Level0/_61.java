package src.Programmers.Java.Level0.Level0;


/*
정수 배열 arr이 매개변수로 주어집니다.
arr의 길이가 2의 정수 거듭제곱이 되도록 arr 뒤에 정수 0을 추가하려고 합니다.
arr에 최소한의 개수로 0을 추가한 배열을 return 하는 solution 함수를 작성해 주세요.
*/

public class _61 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		int[] answer;
		int cnt = 1;
		while (true) {
			if (arr.length > cnt) {
				cnt = cnt * 2;
			} else {
				answer = new int[cnt];
				for (int i=0;i<arr.length; i++){
					answer[i] = arr[i];
 				}
				break;
			}
		}


	}
}


