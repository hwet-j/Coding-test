package src.Programmers.Java.Level1;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _14숫자짝꿍_2 {
    public static void main(String[] args){
        String X = "5525";
        String Y = "1255";

        StringBuffer answer = new StringBuffer("");

        int xleng = X.length();
        int yleng = Y.length();
        // X의 0~9까지 각 개수
        Map<Character, Integer> map = new HashMap<>();
        // Y의 0~9까지 각 개수
        Map<Character, Integer> map2 = new HashMap<>();

        Set<Character> set = new HashSet<>();
        
        // X의 유니크값 가져오기
        for(int i=xleng-1; i>=0; i--){
            set.add(X.charAt(i));
        }
        int xcnt;
        int ycnt;
        for(char s:set){
            xcnt = 0;
            ycnt = 0;
            for (int i=xleng-1; i>=0; i--){
                if (X.charAt(i)==s){
                    xcnt++;
                }
            }
            for (int i=yleng-1; i>=0; i--){
                if (Y.charAt(i)==s){
                    ycnt++;
                }
            }
            map.put(s,xcnt);
            map2.put(s,ycnt);
        }

        for (char c:set){
            if(map.get(c) > map2.get(c)){
                for (int i=map2.get(c); i>0; i--){
                    answer.insert(0,c);
                }
            } else {
                for (int i=map.get(c); i>0; i--){
                    answer.insert(0,c);
                }
            }
        }
        String result = "";
        if(answer.toString().equals("")){
            result = "-1";
        } else {
            BigInteger num = new BigInteger(answer.toString());
            result = "" + num;
        }
        System.out.println(result);
    }
}


