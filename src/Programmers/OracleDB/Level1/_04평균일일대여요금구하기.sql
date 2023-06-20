SELECT ROUND(SUM(DAILY_FEE) / COUNT(CAR_ID)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'

/*
SUM, COUNT 둘다 계산 식이며 WHERE 절에서 SUV 하나의 기준의 정보만 가져오기 때문에 해당 풀이가 가능하다.
만약 다른 정보를 필요로 했다면 GROUP BY 를 사용해서 계산했어야 했을 것이다. (출력하는 컬럼의 ROW수가 같아야한다.)
ROUND 는 반올림해주는 명령어이다. ROUND(데이터, 자리수) 입력해준 자리수 출력한다. = 입력한 자리수 이전에서 반올림 진행
*/
