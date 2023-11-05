package src.Programmers.Java.Level2;


import java.util.Arrays;
import java.util.Comparator;

public class _03k진수에서소수개수구하기 {

	public static int solution(int n, int k) {
		int answer = 0;

		StringBuilder result = new StringBuilder();

		while(n > 0){
			result.insert(0, n % k);
			n = n / k;
		}

		String[] parts = result.toString().split("0+");

		for (String part : parts) {
			if (isPrime(Long.parseLong(part))){
				answer++;
			}
		}

		return answer;
	}

	/*public static boolean isPrime(long number) {
		if (number <= 1) {
			return false;
		}
		if (number <= 3) {
			return true;
		}
		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}

		for (int i = 5; i * i <= number; i += 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}*/

	public static boolean isPrime(long number) {
		if (number <= 1) {
			return false;
		}
		if (number <= 3) {
			return true;
		}
		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}

		long sqrt = (long) Math.sqrt(number);
		for (long i = 5; i <= sqrt; i += 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		int n = 437674;
		int k = 3;
		System.out.println(solution(n,k));

	}



}


/*
주어진 숫자를 특정 진수로 변환 후

0을 기준으로 숫자를 분리하여 각 숫자가 소수인지 확인하여 개수를 확인하는 문제이다.

진수를 변환하고 숫자를 분리하는것까지는 매우 쉽지만, 소수인지 판별하는 부분에서 어려움을 겪었다.

일반적인 방식으로 진행하게 되면 프로그래머스 채점 시 런타임 에러와 시간 초과가 지속적으로 발생했다.

int형 10진수의 숫자를 다른 진수로 변환했을때 숫자가 int의 크기를 초과해버리는 문제가 발생해서 런타임 에러가 발생하여 long타입으로 변환하여 해결하였고,

시간초과는 소수를 판별하는 과정에서 n자체를 판별하지 않고 n의 제곱근까지만 판별하면 된다는 사실을 알게되어 n의 제곱근을 판별하여 해결하였다.

 */