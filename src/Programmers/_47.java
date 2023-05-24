package src.Programmers;


/*
문자열 myString과 pat이 주어집니다.
myString에서 pat이 등장하는 횟수를
return 하는 solution 함수를 완성해 주세요.
*/

public class _47 {
	public static void main(String[] args) {
		String myString = "banana";
		String pat = "ana";
		int answer = 0;

		for (int i=0; i<myString.length()-pat.length()+1;i++){
			if (myString.substring(i, i+pat.length()).equals(pat)) {
				answer += 1;
			}
		}
		System.out.println(answer);

	}
}


