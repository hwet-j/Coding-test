package src.Programmers.Java.Level1;


import java.util.HashMap;
import java.util.Map;

public class _15성격유형검사하기 {
    public static void main(String[] args){
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String[] category = {"R", "T", "C", "F", "J", "M", "A", "N"};
        
        // 유형별 점수를 저장할 map 생성
        Map<String, Integer> map = new HashMap<>();
        for (String c:category){
            map.put(c, 0);
        }

        String key = "";
        for(int i=0;i<survey.length;i++){
            if(choices[i] < 4){
                key = survey[i].split("")[0];
            } else {
                key = survey[i].split("")[1];
            }
            switch (choices[i]){
                case 1:
                    map.replace(key, map.get(key) + 3);
                    break;
                case 2:
                    map.replace(key, map.get(key) + 2);
                    break;
                case 3:
                    map.replace(key, map.get(key) + 1);
                    break;
                case 7:
                    map.replace(key, map.get(key) + 3);
                    break;
                case 6:
                    map.replace(key, map.get(key) + 2);
                    break;
                case 5:
                    map.replace(key, map.get(key) + 1);
                    break;

            }
            System.out.println(map);
        }
        String answer = "";
        if (map.get("R") >= map.get("T")){
            answer += "R";
        } else {
            answer += "T";
        }
        if (map.get("C") >= map.get("F")){
            answer += "C";
        } else {
            answer += "F";
        }
        if (map.get("J") >= map.get("M")){
            answer += "J";
        } else {
            answer += "M";
        }
        if (map.get("A") >= map.get("N")){
            answer += "A";
        } else {
            answer += "N";
        }
        System.out.println(answer);




    }
}



