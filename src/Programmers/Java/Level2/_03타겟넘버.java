package src.Programmers.Java.Level2;

//https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java

public class _03타겟넘버 {

	public static int targetNumber(int[] numbers, int target){
		int length = numbers.length;
		int sum = 0;
		int cnt = 0;

		for (int i=0; i<length; i++){
			sum += numbers[i];
		}

		for (int i=0; i<length; i++){
			if (sum-numbers[i] == target){
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		int[] numbers = {4,1,2,1};
		int target = 4;

		System.out.println(targetNumber(numbers, target));
	}

}

