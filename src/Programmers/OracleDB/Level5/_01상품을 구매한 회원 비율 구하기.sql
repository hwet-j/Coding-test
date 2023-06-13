SELECT
    TO_CHAR(SALES_DATE, 'YYYY') YEAR,
    TO_NUMBER(TO_CHAR(SALES_DATE, 'MM')) MONTH,
    COUNT(DISTINCT USER_ID) PUCHASED_USERS,
    ROUND(COUNT(DISTINCT USER_ID) / (SELECT COUNT(USER_ID)
                            FROM USER_INFO WHERE TO_CHAR(JOINED, 'YYYY') = '2021'),1)
    AS PUCHASED_RATIO
FROM ONLINE_SALE
WHERE USER_ID IN (SELECT USER_ID
                FROM USER_INFO
                WHERE TO_CHAR(JOINED, 'YYYY') = '2021')
GROUP BY TO_CHAR(SALES_DATE, 'YYYY'), TO_CHAR(SALES_DATE, 'MM')
ORDER BY 1, 2




/*
ONLINE _SALE 테이블에서
2021년에 가입한 USER_ID의 데이터만 사용 ( 서브쿼리 WHERE절 )
GROUP BY절에서 년, 월로 그룹화를 진행
SELECT 절에서 년, 월로 구분한 상태에서 조회되는 USER_ID의 개수를 COUNT하여
2021년에 가입한 유저중 상품을 구매한 USER_ID를 계산해준다.
여기서 그냥 USER_ID로 작성하게되면 상품을 2개 이상 구매한 USER_ID의 모든 개수를 COUNT하기 때문에
중복을 제거시켜주는 작업을 진행해야한다. -> COUNT (DISTINCT USER_ID)를 사용해서 중복제거
마지막으로 2021년에 가입한 총인원중 몇명이 구매를 진행했는가를 계산해야하는데
2021년에 가입한 총인원을 서브쿼리로 생성하여 COUNT (DISTINCT USER_ID) 를 나눠준다.
정렬은 년, 월 순으로 오름차순 정렬
*/