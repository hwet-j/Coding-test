package src.Programmers.Level1;

public class _08둘만의암호2 {
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;

		int[] str_arr = new int[s.length()];
		int[] skip_arr = new int[skip.length()];

		for (int i=0; i<s.length();i++){
			str_arr[i] = (int)s.charAt(i);
		}
		for (int i=0; i<skip.length();i++){
			skip_arr[i] = (int)skip.charAt(i);
		}
		char[] char_arr = new char[s.length()];

		int cnt = 0;
		int block = 0;

		for (int i=0; i<str_arr.length;i++){
			int n = str_arr[i];
			while(true){
				n = n+1;
				if (n > 122){
					n = n - 26;
				}
				block= 0;
				for (int j = 0; j < skip_arr.length; j++) {
					if (n == skip_arr[j]) {
						block = -1;
						break;
					}
				}

				if(block == 0){
					cnt++;
				}

				if (cnt == index)break;
			}
			char_arr[i] = (char)(n);
			cnt = 0;
		}

		String answer = "";

		for(int i=0;i<char_arr.length;i++){
			answer += char_arr[i];
		}
		System.out.println(answer);
	}
}

// n이 122를 넘었을때 26을 뺴주지 않고
// if문에서 122가 넘었을때 조건을 작성하여 식을 작성하면 결과물에 26을 빼도 122가넘는 문제가 발생하기도 하는듯하다.
// 그렇기에 애초에 n이 122를 넘으면 26을 뺴버린다.(코드도 간단해진다.)