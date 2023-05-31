package src.Programmers.Level0;


/*
0 이상의 두 정수가 문자열 a, b로 주어질 때,
a + b의 값을 문자열로 return 하는 solution 함수를 작성해 주세요.
*/

import java.math.BigInteger;

public class _72 {
	public static void main(String[] args) {
		String a = "18446744073709551615";
		String b = "287346502836570928366";
		BigInteger bigA = new BigInteger(a);
		BigInteger bigB = new BigInteger(b);

		BigInteger bigC = bigA.add(bigB);
		System.out.println(bigC);



	}
}


