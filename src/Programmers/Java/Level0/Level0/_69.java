package src.Programmers.Java.Level0.Level0;


/*
한 자리 정수로 이루어진 문자열 num_str이 주어질 때,
각 자리수의 합을 return하도록 solution 함수를 완성해주세요.
*/

public class _69 {
	public static void main(String[] args) {
		String num_str = "123456789";

		String[] num_Arr = num_str.split("");
		int sum = 0;
		for (int i=0;i<num_Arr.length; i++){
			sum += Integer.parseInt(num_Arr[i]);
		}




	}
}


