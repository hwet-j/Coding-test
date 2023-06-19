package src.Programmers.Java.Level1;


import java.util.*;

public class _24완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        // 동일한 이름이 존재할 수 있으니 이름별 참가자 수를 저장
        Map<String, Integer> countMap = new HashMap<>();
        // 이름마다 map에 현재 데이터가 존재하지 않으면 0으로 설정하고 + 1
        // 이미 존재하면 존재한 값에서 + 1
        for (String part : participant) {
            countMap.put(part, countMap.getOrDefault(part, 0) + 1);
        }

        // 완주자 이름이 참가자 명단에 존재하면 map의 value값 -1
        // value 값이 0이면 동일한 참가자는 더이상없으므로 삭제 
        // --> 삭제해주지 않으면 코드가 무거워져 통과할 수 없음
        for (int i=0; i<completion.length; i++){
            if (countMap.keySet().contains(completion[i])){
                countMap.replace(completion[i], countMap.get(completion[i]) - 1);
                if (countMap.get(completion[i]) == 0){
                    countMap.remove(completion[i]);
                }
            }
        }
        String answer = "";
        for(String key : countMap.keySet()){
            answer = key;
        }

    }
}


/*

*/