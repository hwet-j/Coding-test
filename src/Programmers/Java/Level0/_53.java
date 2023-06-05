package src.Programmers.Java.Level0;


/*
문자열 binomial이 매개변수로 주어집니다.
binomial은 "a op b" 형태의 이항식이고 a와 b는 음이
아닌 정수, op는 '+', '-', '*' 중 하나입니다.

주어진 식을 계산한 정수를 return 하는 solution 함수를 작성해 주세요.
*/

public class _53 {
	public static void main(String[] args) {
		String binomial = "43 + 12";
		String[] strArr = binomial.split(" ");
		int answer = 0;
		if (strArr[1].equals("+")){
			answer = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
		} else if (strArr[1].equals("-")){
			answer = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2]);
		} else {
			answer = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[2]);
		}

	}
}


