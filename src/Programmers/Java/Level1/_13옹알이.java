package src.Programmers.Java.Level1;


public class _13옹알이 {
    public static void main(String[] args){
        // "aya", "ye", "woo", "ma" 옹알이 가능
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        String temp = "";
        int answer = 0;
        int block = 0;      // 조건을 만족하면 0, 불만족 1
        
        for (String say:babbling){
            // 조건 초기화
            block = 0;
            temp = "";
            for(int i = 0; i < say.length(); i++){
                // 시작 단어 체크
                String first_word = say.substring(i, i+1);
                // a,y,m,w 를 나누어 작성
                if(first_word.equals("a")){
                    if(i < say.length()-2 && say.substring(i, i+3).equals("aya")){  // 길이 및 소리 확인
                        if (temp == "aya"){         // 이전과 같은 소리의 옹알이를 낼 수 없음
                            block = 1;
                            break;
                        }
                        temp = "aya";       // 소리를 내면 다음 소리와 비교하기위해 temp저장
                        i = i + 2;          // 소리를 내면 소리낸 만큼 넘어감
                    } else {    // 길이 또는 소리가 문제있으면 옹알이 핲 수 없음
                        block = 1;
                        break;
                    }
                } else if(first_word.equals("y")){
                    if(i < say.length()-1 && say.substring(i, i+2).equals("ye")){
                        if (temp == "ye"){
                            block = 1;
                            break;
                        }
                        temp = "ye";
                        i = i + 1;
                    } else {
                        block = 1;
                        break;
                    }
                } else if(first_word.equals("m")){
                    if(i < say.length()-1 && say.substring(i, i+2).equals("ma")){
                        if (temp == "ma"){
                            block = 1;
                            break;
                        }
                        temp = "ma";
                        i = i + 1;
                    } else {
                        block = 1;
                        break;
                    }
                } else if(first_word.equals("w")){
                    if(i < say.length()-2 && say.substring(i, i+3).equals("woo")){
                        if (temp == "woo"){
                            block = 1;
                            break;
                        }
                        temp = "woo";
                        i = i + 2;
                    } else {
                        block = 1;
                        break;
                    }
                } else {
                    block = 1;
                    break;
                }
            }
            if (block == 0){
                answer++;
            }
        }
        System.out.println(answer);
    }
}


// 다른 사람 풀이..
/*

    // "aya", "ye", "woo", "ma" 4가지 발음만 가능
    int answer = 0;
        for(int i = 0; i < babblings.length; i++) {
        if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
        continue;
        }

        babblings[i] = babblings[i].replace("aya", " ");
        babblings[i] = babblings[i].replace("ye", " ");
        babblings[i] = babblings[i].replace("woo", " ");
        babblings[i] = babblings[i].replace("ma", " ");
        babblings[i] = babblings[i].replace(" ", "");

        if(babblings[i].length()  == 0) answer++;

        }
        return answer;

// 소리가 두번 연속된 문자를 포함하면 제외 (연속해서 같은 발음의 옹알이 불가)
// 한번에 ""로 치환하면 제거된 위치에서 양옆의 문자끼리 붙어버리므로 처음에 공백을 넣어 " "로 치환하였다가 모든 옹알이에 대해 작업이 완료되고나서 " "를 ""로 치환한다.
*/
