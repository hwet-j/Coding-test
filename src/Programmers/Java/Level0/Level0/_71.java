package src.Programmers.Java.Level0.Level0;


/*
정수로 이루어진 문자열 n_str이 주어질 때, n_str의 가장 왼쪽에 처음으로
등장하는 0들을 뗀 문자열을 return하도록 solution 함수를 완성해주세요.
*/

public class _71 {
	public static void main(String[] args) {
		String n_str = "0010";

		int intVar = Integer.parseInt(n_str);
		String answer = "" + intVar;

		System.out.println(answer);
	}
}


