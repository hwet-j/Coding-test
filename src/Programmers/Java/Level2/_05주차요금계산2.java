package src.Programmers.Java.Level2;

import java.util.*;

public class _05주차요금계산2 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};

		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

		// 입차 기록만 있는가, 출차까지 있는가
		Set<String> oddNumber = new LinkedHashSet<>();
		Set<String> evenNumber = new LinkedHashSet<>();

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

		// 자동차별 입출차 기록 시간 계산 (분단위)




	}
}

