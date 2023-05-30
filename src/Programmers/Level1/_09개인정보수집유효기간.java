package src.Programmers.Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _09개인정보수집유효기간 {
	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		String[] testArr = today.split("[.]");		// . 을 기준으로 문자열을 나누려면 단순 입력으로는 안된다. [] 로 감싸주던가 \\. 로입력해줘야한다.

		int today_year = Integer.parseInt(testArr[0]);
		int today_month = Integer.parseInt(testArr[1]);
		int today_day = Integer.parseInt(testArr[2]);

		Map<String, Integer> termMap = new HashMap<>();
		// Map을 사용하여 약관에 따른 기간을 key,value로 저장
		for (int i=0; i<terms.length;i++){
			termMap.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
		}

		int block = 0;
		int cnt = 0;
		int[] answer = new int[privacies.length];

		for (int i=0; i<privacies.length;i++){
			// 약관이 지났으면 -1, 아니면 0
			block = 0;
			// 약관에 따른 value값 가져오기
			int termMonth = termMap.get(privacies[i].split(" ")[1]);
			
			// 약관 시작일을 나누어 저장
			String date = privacies[i].split(" ")[0];
			int str_year = Integer.parseInt(date.split("[.]")[0]);
			int str_month = Integer.parseInt(date.split("[.]")[1]);
			int str_day = Integer.parseInt(date.split("[.]")[2]);

			str_day = str_day - 1;
			if (str_day == 0){
				str_day = 28;
				str_month -= 1;
				if (str_month == 0){
					str_month = 12;
					str_year -= 1;
				}
			}

			str_month = str_month + termMonth;
			// 개월은 12개월 까지로 12를 초과하면 -12해주고 년도에 1년 추가
			while (str_month > 12){
				str_year += 1;
				str_month -= 12;
			}

			if (today_year > str_year){
				block = -1;
			} else if (today_year == str_year){
				if (today_month > str_month){
					block = -1;
				} else if (today_month == str_month){
					if (today_day > str_day){
						block = -1;
					}
				}
			}
			if (block == -1){
				answer[cnt++] = i+1;
			}
		}
		answer = Arrays.copyOf(answer, cnt);
		System.out.println(Arrays.toString(answer));

	}
}

