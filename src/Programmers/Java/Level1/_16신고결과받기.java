package src.Programmers.Java.Level1;


import java.util.*;

public class _16신고결과받기 {
    public static void main(String[] args){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Set[] reportSet = new HashSet[id_list.length];

        // 유저별 신고한 유저를 저장할 객체
        Map<String, Integer> map = new HashMap();
        // 유저별 정지당했는가 여부
        Map<String, Boolean> map2 = new HashMap();

        // reportSet의 번호를 value와 맵핑하기위해 작성
        for (int i=0; i<id_list.length; i++){
            map.put(id_list[i], i);
            reportSet[i] = new HashSet<String>();
        }

        String user = "";
        String reported = "";
        // 유저별 신고한 유저 입력
        for(int i=0; i< report.length; i++){
            user = report[i].split(" ")[0];
            reported = report[i].split(" ")[1];
            reportSet[map.get(user)].add(reported);
        }

        int cnt = 0;

        // 정지당했는가 여부 map2에 저장
        for(int i=0; i<id_list.length;i++){
            cnt = 0;
            for(int j=0;j<reportSet.length;j++){
                if(reportSet[j].contains(id_list[i])){
                    cnt++ ;
                }
            }
            if (cnt >= k){
                map2.put(id_list[i], true);
            } else {
                map2.put(id_list[i], false);
            }
        }
        
        // 정답
        int[] result = new int[id_list.length];
        
        for (int i=0;i<id_list.length;i++){
            for(Object obj:reportSet[i]){   // 각유저가 신고한 유저명 가져오기
                if(map2.get(obj)){      // 정지당했다면 + 1
                    result[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(result));


    }
}



