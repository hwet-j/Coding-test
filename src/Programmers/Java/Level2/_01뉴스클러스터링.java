package src.Programmers.Java.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _01뉴스클러스터링 {
	public static void main(String[] args) {
		String str1 = "abab";
		String str2 = "baba";
		// 두 데이터는 대소문자를 구분하지 않음
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		// 영문자를 제외한 문자는 비교 대상에서 제외
		str1 = str1.replaceAll("[^A-Z]", " ");
		str2 = str2.replaceAll("[^A-Z]", " ");

		StringBuffer[] arrStr1 = new StringBuffer[str1.length()-1];
		StringBuffer[] arrStr2 = new StringBuffer[str2.length()-1];
		int cnt = 0;

		// 문자 집합 1
		for (int i=0; i< arrStr1.length; i++){
			// 특수문자나 공백이었으면 그에 대한 문자는 제거 (전부 공백으로 변경했기 때문에 공백으로 확인)
			if (str1.charAt(i) == ' ' || str1.charAt(i+1) == ' '){
				continue;
			}
			arrStr1[cnt] = new StringBuffer();
			arrStr1[cnt].append(str1.charAt(i));
			arrStr1[cnt++].append(str1.charAt(i+1));
		}
		// 길이 조절
		arrStr1 = Arrays.copyOf(arrStr1, cnt);
		
		cnt = 0;
		// 문자 집합 2
		for (int i=0; i< arrStr2.length; i++){
			if (str2.charAt(i) == ' ' || str2.charAt(i+1) == ' '){
				continue;
			}
			arrStr2[cnt] = new StringBuffer();
			arrStr2[cnt].append(str2.charAt(i));
			arrStr2[cnt++].append(str2.charAt(i+1));
		}
		arrStr2 = Arrays.copyOf(arrStr2, cnt);

		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		// arrStr1 배열 요소 처리
		for (StringBuffer sb : arrStr1) {
			String key = sb.toString();
			if (map.containsKey(key)) {
				// 이미 존재하는 키인 경우 개수 증가
				map.put(key, map.get(key) + 1);
			} else {
				// 새로운 키인 경우 개수 1로 초기화
				map.put(key, 1);
			}
		}

		// arrStr2 배열 요소 처리
		for (StringBuffer sb : arrStr2) {
			String key = sb.toString();
			if (map2.containsKey(key)) {
				// 이미 존재하는 키인 경우 개수 증가
				map2.put(key, map2.get(key) + 1);
			} else {
				// 새로운 키인 경우 개수 1로 초기화
				map2.put(key, 1);
			}
		}

		HashMap<String, Integer> intersectionMap = new HashMap<>();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();

			if (map2.containsKey(key)) {
				int intersectionValue = Math.min(value, map2.get(key));
				intersectionMap.put(key, intersectionValue);
			}
		}
		System.out.println(intersectionMap);

		HashMap<String, Integer> unionMap = new HashMap<>(map);
		unionMap.putAll(map2);

		for (Map.Entry<String, Integer> entry : unionMap.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();

			if (map2.containsKey(key)) {
				int unionValue = Math.max(value, map2.get(key));
				unionMap.put(key, unionValue);
			}
			if (map.containsKey(key)) {
				int unionValue = Math.max(value, map.get(key));
				unionMap.put(key, unionValue);
			}
		}

		int intersectionCnt = 0;

		System.out.println(map);
		System.out.println(map2);

		// 교집합 출력
		System.out.println("교집합:");
		for (Map.Entry<String, Integer> entry : intersectionMap.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println("Key: " + key + ", Value: " + value);
			intersectionCnt += value;
		}

		int unionCnt = 0;

		// 합집합 출력
		System.out.println("합집합:");
		for (Map.Entry<String, Integer> entry : unionMap.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println("Key: " + key + ", Value: " + value);
			unionCnt += value;
		}

		int result = (int) (65536 * (1.0 * intersectionCnt / unionCnt));
		if(arrStr1.length == 0 && arrStr2.length == 0){
			result = 65536;
		}

		System.out.println(result);
	}
}


/*
4,7,9,10,11 반례
str1 = "abab", str2 = "baba"
ab, ba, ab와 ba, ab, ba에 대하여 자카드 값 0.5로 32768이 나와야 합니다.
---------------------------------------------------------

영문자를 제외한 나머지와 조합이되면, 그 문자는 제외하고 비교를 진행하므로
영문자를 제외한 나머지를 " " 공백으로 대체하여 공백을 포함하면 제외하도록 작성함


putAll 메서드와
intersectionMap.keySet().retainAll(map2.keySet());
를 사용해서 map의 key value까지 전부 맞추기에는 문제가 있다.
key값에 대한 교집합 합집합은 정확하게 처리하는듯 하지만, value값은 어떻게 해야하는지
비교 대상이 명확하지 않기 때문에 문제가 발생한다. 그래서
각 교집합, 합집합을 만드는 과정에서 추가적으로 if문에서 값을 비교하여 적절한 값을 대입하도록 작성

또한, 두 데이터의 길이가 0인 경우 비교대상이 없으므로 자카드 유사도는 1로 설정되어야 한다. 
==> 결과에 65536 을 곱한다 했으니 65536의 값을 나타내야함

초반에 StringBuffer를 사용하였는데 이는 단순히 여러가지 함수를 다양하게 사용해보기 위함.
별 의미없이 사용

* */