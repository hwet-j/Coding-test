package src.Programmers.Java.Level1;


public class _19신규아이디추천 {
    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";
        String answer = "";

        // 1단계: 대문자를 소문자로 변환
        new_id = new_id.toLowerCase();
        System.out.println("1단계 결과: " + new_id);

        // 2단계: 허용되지 않는 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        System.out.println("2단계 결과: " + new_id);

        // 3단계: 연속된 마침표 하나로 치환
        new_id = new_id.replaceAll("[.]+", ".");
        System.out.println("3단계 결과: " + new_id);

        // 4단계: 처음이나 끝에 위치한 마침표 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        System.out.println("4단계 결과: " + new_id);

        // 5단계: 빈 문자열이면 "a" 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        System.out.println("5단계 결과: " + new_id);

        // 6단계: 길이가 16자 이상이면 제거, 마지막이 마침표면 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }
        System.out.println("6단계 결과: " + new_id);

        // 7단계: 길이가 2자 이하라면 마지막 문자 반복해서 붙이기
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        System.out.println("7단계 결과: " + new_id);
    }
}

