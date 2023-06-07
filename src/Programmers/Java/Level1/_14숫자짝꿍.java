package src.Programmers.Java.Level1;


import java.math.BigInteger;
import java.util.*;

public class _14숫자짝꿍 {
    public static void main(String[] args){
        String X = "100";
        String Y = "203045";

        // X의 0~9까지 각 개수
        Map<String, Integer> map = new HashMap<>();
        // Y의 0~9까지 각 개수
        Map<String, Integer> map2 = new HashMap<>();
        // X,Y의 0~9까지 짝꿍 개수
        Map<String, Integer> map3 = new HashMap<>();
        // X,Y 초기 세팅 (개수 count이전 value 0)
        for (int i=0; i<10;i++){
            map.put(""+i,0);
            map2.put(""+i,0);
        }
        int xleng = X.length();
        int yleng = Y.length();
        String xvalue = "";
        String yvalue = "";

        // X, Y 각각
        for(int i=0;i<xleng;i++){
            xvalue = X.substring(i,i+1);
            map.replace(xvalue ,map.get(xvalue) + 1);
        }
        for(int i=0;i<yleng;i++){
            yvalue = Y.substring(i,i+1);
            map2.replace(yvalue ,map2.get(yvalue) + 1);
        }


        for (int i=0; i<10;i++){
            if (map.get(""+i) > map2.get(""+i)){
                map3.put(""+i,map2.get(""+i));
            } else {
                map3.put(""+i,map.get(""+i));
            }
        }

        String answer = "";
        for (int i=9; i>=0;i--){
            if(map3.get(""+i) != 0){
                for (int j=0; j < map3.get(""+i);j++){
                    answer += i;
                }
            }
        }
        if(answer.equals("")){
            answer = "-1";
        } else {
            BigInteger num = new BigInteger(answer);
            answer = "" +num;
        }
        System.out.println(answer);
    }
}


