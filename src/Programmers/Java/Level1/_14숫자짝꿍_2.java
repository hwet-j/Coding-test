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
        
        // String타입 대신 문자열을 연산하기위해 객체 선언
        StringBuilder temp = new StringBuilder();

        // 길이
        int xleng = X.length();
        int yleng = Y.length();
        // X의 0~9까지 각 개수
        int[] xvalue = new int[10];
        // Y의 0~9까지 각 개수
        int[] yvalue = new int[10];
        // X,Y의 짝꿍 개수
        int xymate = 0;

        // X, Y의 유니크값 가져오기
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < xleng; i++) {
                if (Character.getNumericValue(X.charAt(i)) == j) {
                    xvalue[j] += 1;
                }
            }
            for (int i = 0; i < yleng; i++) {
                if (Character.getNumericValue(Y.charAt(i)) == j) {
                    yvalue[j] += 1;
                }
            }
        }
        // 앞에서부터 큰수가 작성되어야 하기 떄문에 9 -> 0순으로 진행
        for (int j = 9; j >= 0; j--) {
            // X,Y의 짝꿍 개수
            xymate = Math.min(xvalue[j], yvalue[j]);
            for (int i = 0; i < xymate; i++) {
                temp.append(j);
            }
        }
        String answer = "";
        if (temp.toString().equals("")){    // 비어있으면 짝궁이없음
            answer = "-1";
        } else {
            answer = temp.toString();
            if(answer.substring(0,1).equals("0")){  // 가장앞숫자가 0이면 0
                answer = "0";
            }
        }
        System.out.println(answer);

    }
}


/*
* 시간초과 때문에 애먹은 문제
* for문에서 조건에 x.length()와같은 메서드를 사용하면 for문이 1회 진행될때마다 메서드가 호출되기 때문에 지양하는게 좋다.
* x.length()를 사용하고 싶다면 시작점으로 설정하고 하나씩 빼는 형식으로 작성한다.
* 아니면 x.length()를 변수에 저장하여 저장된 변수를 사용한다.
* String보다 Character가 더욱 가볍다. (메모리할당량이 낮다)
* String타입에서 + 연산을하면 + 연산을 할때마다 새로운 문자열을 생성하고 할당하는 작업을 한다.
* 그렇기 때문에 매우 무거워질수있다. 이때 StringBuilder 또는 StringBuffer를 사용하면 좋다. (가변객체)
* 또한, 숫자 계산을 위해서 Biginteger를 사용했었는데 매우 무거운 객체인듯하다. 무슨짓을해도 시간초과가 뜬다.
* */
