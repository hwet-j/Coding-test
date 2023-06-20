SELECT a.CAR_ID, ROUND(a.TOTAL/a.CNT, 1) AS AVERAGE_DURATION
FROM (SELECT CAR_ID, SUM(END_DATE - START_DATE+1) AS TOTAL, COUNT(CAR_ID) AS CNT
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID) a
WHERE ROUND(a.TOTAL/a.CNT, 1) >= 7
ORDER BY AVERAGE_DURATION DESC , a.CAR_ID DESC


-- 서브 쿼리를 사용하여 CAR_ID를 그룹화 하여 총 대여기간과 대여횟수를 계산한다.
-- 계산된 서브쿼리를 사용해서 평균기간을 계산하여 출력
-- 주의! WHERE절이 SELECT절 보다 순서가 더 빠르므로 ALIAS를 사용할 수 없다.
-- FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
-- 오라클이 아닌 다른 SQL문에서는 SELECT ALIAS가 가장 먼저 된다고도 하지만, 오라클은 별칭도 SELECT와 같이실행됨