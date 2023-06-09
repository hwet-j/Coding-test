SELECT DISTINCT(a.CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR a JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY b
ON a.CAR_ID = b.CAR_ID
WHERE a.CAR_TYPE LIKE '%세단%'
AND TO_CHAR(START_DATE,'YYYY-MM') = '2022-10'
ORDER BY a.CAR_ID DESC


/*
대여한 기록이 있는 CAR_ID 들의 기록만 확인하기 위해 두 테이블을 JOIN 해주고,
CAR_TYPE이 세단인것 중에서 대여 시작일이 2022년 10월인 것들만 확인하며
DISTINCT로 중복을 제거하여 출력한다.
*/