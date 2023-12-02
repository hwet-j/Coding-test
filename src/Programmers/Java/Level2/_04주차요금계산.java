package src.Programmers.Java.Level2;

import java.util.*;

public class _04주차요금계산 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};

		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

		// 자동차별 기록 횟수 (짝수는 출차기록까지, 홀수는 출차기록 없음)
		Map<String, Integer> carEnter = new HashMap<>();

		for (String item : records){
			String carNumber = item.split(" ")[1];
			if (carEnter.containsKey(carNumber)){
				carEnter.replace(carNumber, carEnter.get(carNumber) + 1);
			} else {
				carEnter.put(carNumber, 1);
			}
		}

		Map<String, Integer> parkingTime = new HashMap<>();

		int tempHour = 0;
		int tempMinute = 0;

		// 자동차별 주차 시간 초기값
		for (String carN : carEnter.keySet()){
			parkingTime.put(carN, 0);

			// 출차기록까지 존재
			if (carEnter.get(carN) % 2 == 0){
				for (String item : records){
					if (item.split(" ")[1].equals(carN)){
						if (carEnter.get(carN) % 2 == 0){	// 입차 기록
							tempHour = Integer.parseInt(item.split(" ")[0].split(":")[0]);
							tempMinute = Integer.parseInt(item.split(" ")[0].split(":")[1]);
							carEnter.replace(carN, carEnter.get(carN) - 1);
						} else {		// 출차 기록
							int hour = Integer.parseInt(item.split(" ")[0].split(":")[0]) - tempHour;
							int minute = Integer.parseInt(item.split(" ")[0].split(":")[1]) - tempMinute;

							// 주차시간 계산
							int useMinute = 0;
							if (minute >= 0){
								useMinute = hour * 60 + minute;
							} else {
								useMinute = (hour-1) * 60 + (60 + minute);
							}

							parkingTime.replace(carN,  parkingTime.get(carN) + useMinute);

							// 입차 기록 초기화
							tempHour = 0;
							tempMinute = 0;
							carEnter.replace(carN, carEnter.get(carN) - 1);
						}
					}
				}
			} else {
				for (String item : records){
					if (item.split(" ")[1].equals(carN)){
						if (carEnter.get(carN) % 2 != 0){	// 입차 기록
							tempHour = Integer.parseInt(item.split(" ")[0].split(":")[0]);
							tempMinute = Integer.parseInt(item.split(" ")[0].split(":")[1]);
							carEnter.replace(carN, carEnter.get(carN) - 1);
							if (carEnter.get(carN) == 0){
								int hour = 23 - tempHour;
								int minute = 59 - tempMinute;
								int useMinute = 0;

								if (minute >= 0){
									useMinute = hour * 60 + minute;
								} else {
									useMinute = (hour-1) * 60 + (60 + minute);
								}

								parkingTime.replace(carN,  parkingTime.get(carN) + useMinute);
							}
						} else {		// 출차 기록
							int hour = Integer.parseInt(item.split(" ")[0].split(":")[0]) - tempHour;
							int minute = Integer.parseInt(item.split(" ")[0].split(":")[1]) - tempMinute;

							// 주차시간 계산
							int useMinute = 0;
							if (minute >= 0){
								useMinute = hour * 60 + minute;
							} else {
								useMinute = (hour-1) * 60 + (60 + minute);
							}

							parkingTime.replace(carN,  parkingTime.get(carN) + useMinute);

							// 입차 기록 초기화
							tempHour = 0;
							tempMinute = 0;
							carEnter.replace(carN, carEnter.get(carN) - 1);
						}
					}
				}
			}
		}

		// TreeMap을 사용하여 Key를 기준으로 오름차순으로 정렬한다.
		Map<String, Integer> sortedMap = new TreeMap<>(parkingTime);

		// 프로그래머스의 정답은 배열로 제출해야함
		int[] answer = new int[sortedMap.size()];
		int index = 0;

		for (String item : sortedMap.keySet()){
			int time = sortedMap.get(item);
			if (time <= fees[0]){
				answer[index] = fees[1];
			} else {
				int restTimeFee = (time - fees[0]) / fees[2] * fees[3];
				if ((time - fees[0]) % fees[2] > 0){
					restTimeFee = restTimeFee + fees[3];
				}

				answer[index] = fees[1] + restTimeFee;
			}
			index++;
		}

	}
}

/*

주차 기록에 입차/출차 기록이 존재하는데 입차 기록은 있지만 출차 기록이 없을 수 있다. 이 경우를 구분하여 조건을 설정하기 위해서
자동차별 입/출차 기록의 개수를 확인하여 짝수면 최종적으로 출차기록이 있는기록으로, 홀수면 최종적으로 출차기록이 존재하지 않은것으로 간주한다.
출차 기록이 없으면 23:59기준을 계산하여 출차했다고 가정한다.

1. Map을 생성하여 자동차별 입/출차 기록의 개수를 계산한다.

2. 새로운 Map을 생성하여 자동차별 주차시간(분단위)을 계산한다.
이때, 입/출차 기록개수를 기준으로 계산을 진행하며 주의해야할 점은 홀수는 최종적으로 23:59를 기준으로 출차한것으로 계산을 따로 한번 해줘야한다는 것

3. 정답처리는 자동차의 번호를 오름차순으로 정렬하여 그에따른 주차비를 배열화 하여 나열해야한다.
TreeMap는 기본적으로 Key를 오름차순으로 정렬하여 저장하기 때문에 이를 활용한다.
만약 내림차순으로 정렬하고싶다면 람다식을 활용하면 된다.   TreeMap<Integer, String> treeMapDescending = new TreeMap<>((a, b) -> b.compareTo(a));





* */