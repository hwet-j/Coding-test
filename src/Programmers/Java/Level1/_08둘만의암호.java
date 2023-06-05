package src.Programmers.Java.Level1;

public class _08둘만의암호 {
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";

		int[] str_arr = new int[s.length()];
		int[] skip_arr = new int[skip.length()];

		for (int i=0; i<s.length();i++){
			str_arr[i] = (int)s.charAt(i);
		}
		for (int i=0; i<skip.length();i++){
			skip_arr[i] = (int)skip.charAt(i);
		}
		char[] char_arr = new char[s.length()];

		int index = 5;
		int cnt = 0;
		int block = 0;

		for (int i=0; i<str_arr.length;i++){
			int n = str_arr[i];
			while(true){
				n = n+1;
				block= 0;
				if(n < 123) {
					for (int j = 0; j < skip_arr.length; j++) {
						if (n == skip_arr[j]) {
							block = -1;
							break;
						}
					}
				} else {
					for (int j = 0; j < skip_arr.length; j++) {
						if (n - 26 == skip_arr[j]) {
							block = -1;
							break;
						}
					}
				}
				if(block == 0){
					cnt++;
				}

				if (cnt == index)break;
			}
			if (n > 122){
				char_arr[i] = (char)(n - 26);
			} else {
				char_arr[i] = (char)(n);
			}
			System.out.println(n);
			cnt = 0;
		}

		String answer = "";

		for(int i=0;i<char_arr.length;i++){
			answer += char_arr[i];
		}

		System.out.println(answer);


	}
}

