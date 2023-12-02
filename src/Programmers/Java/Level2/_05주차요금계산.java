package src.Programmers.Java.Level2;

import java.util.*;

public class _05주차요금계산 {

	public static void main(String[] args) {
		int[] fees = {1, 461, 1, 10};

		String[] records = {"00:00 1234 IN"};

		Set<String> carNumber = new LinkedHashSet<>();
		Set<String> oddNumber = new LinkedHashSet<>();
		Set<String> evenNumber = new LinkedHashSet<>();

		for (String item : records){
			carNumber.add(item.split(" ")[1]);
		}
		// 출차기록이 모두 있는 차 정보
		for (String item : records){
			oddNumber.add(item.split(" ")[1]);
			if (item.split(" ")[2].equals("OUT")){
				oddNumber.remove(item.split(" ")[1]);
			}
		}

		// 출차기록이 마지막에 없는 차 정보
		for (String item : records){
			evenNumber.add(item.split(" ")[1]);
			if (item.split(" ")[2].equals("IN")){
				evenNumber.remove(item.split(" ")[1]);
			}
		}

		int tempHour = 0;
		int tempMinute = 0;
		int count = 0;

		Map<String, Integer> parkingTime = new HashMap<>();

		// 자동차 번호로 각 계산되는 주차시간 계산 (출차기록 존재)
		for (String carN : evenNumber){
			parkingTime.put(carN, 0);
			for (String item : records){
				if (item.split(" ")[1].equals(carN)){
					if (count == 0){	// 입차 기록
						tempHour = Integer.parseInt(item.split(" ")[0].split(":")[0]);
						tempMinute = Integer.parseInt(item.split(" ")[0].split(":")[1]);
						count++;
					} else {		// 출차 기록
						count = 0;
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
					}
				}
			}
		}
		
		// 자동차 번호로 각 계산되는 주차시간 계산 (출차기록 존재 X)
		String tempCar = "";
		int useMinute = 0;
		for (String carN : oddNumber){
			useMinute = 0;

			if (tempMinute != 0 || tempHour != 0){
				int hour = 23 - tempHour;
				int minute = 59 - tempMinute;

				if (minute >= 0){
					useMinute = hour * 60 + minute;
				} else {
					useMinute = (hour-1) * 60 + (60 + minute);
				}

				parkingTime.replace(tempCar,  parkingTime.get(tempCar) + useMinute);
			}

			tempCar = carN;

			parkingTime.put(carN, 0);
			for (String item : records){
				if (item.split(" ")[1].equals(carN)){
					if (count == 0){	// 입차 기록
						tempHour = Integer.parseInt(item.split(" ")[0].split(":")[0]);
						tempMinute = Integer.parseInt(item.split(" ")[0].split(":")[1]);
						if (tempMinute == 0 || tempHour == 0){
							int hour = 23 - tempHour;
							int minute = 59 - tempMinute;

							if (minute >= 0){
								useMinute = hour * 60 + minute;
							} else {
								useMinute = (hour-1) * 60 + (60 + minute);
							}

							parkingTime.replace(tempCar,  parkingTime.get(tempCar) + useMinute);
						}
						count++;
					} else {		// 출차 기록
						count = 0;
						int hour = Integer.parseInt(item.split(" ")[0].split(":")[0]) - tempHour;
						int minute = Integer.parseInt(item.split(" ")[0].split(":")[1]) - tempMinute;

						// 주차시간 계산
						useMinute = 0;
						if (minute >= 0){
							useMinute = hour * 60 + minute;
						} else {
							useMinute = (hour-1) * 60 + (60 + minute);
						}

						parkingTime.replace(carN,  parkingTime.get(carN) + useMinute);

						// 입차 기록 초기화
						tempHour = 0;
						tempMinute = 0;
					}

				}
			}
		}

		if (tempMinute != 0 || tempHour != 0){
			int hour = 23 - tempHour;
			int minute = 59 - tempMinute;

			if (minute >= 0){
				useMinute = hour * 60 + minute;
			} else {
				useMinute = (hour-1) * 60 + (60 + minute);
			}

			parkingTime.replace(tempCar,  parkingTime.get(tempCar) + useMinute);
		}
		Map<String, Integer> sortedMap = new TreeMap<>(parkingTime);

		System.out.println(sortedMap);

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

		for (int an : answer){
			System.out.println(an);
		}
	}

}

