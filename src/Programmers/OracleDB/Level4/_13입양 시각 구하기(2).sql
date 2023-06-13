SELECT a.HOUR AS "HOUR",
CASE b.COUNT
WHEN b.COUNT THEN b.COUNT
ELSE 0
END AS "COUNT"
FROM
(SELECT LEVEL-1 AS  HOUR
FROM DUAL
CONNECT BY LEVEL <= 24) a
LEFT OUTER JOIN
(SELECT EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP)) HOUR, COUNT(ANIMAL_ID) COUNT
FROM ANIMAL_OUTS
GROUP BY EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP))) b
ON a.HOUR = b.HOUR
ORDER BY a.HOUR


/*
0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회 /  시간대 순으로 정렬
시간대별로 그룹화 , COUNT로 입양 건수 계산 시간으로 정렬

--> COUNT가 0 입양 데이터가 없는 시간대도 나와야 정답처리

SELECT      LEVEL-1 AS  "HOUR"
FROM        DUAL
CONNECT BY LEVEL <= 24
로 0~23 까지 정수 작성

위의 두개의 쿼리문을 FROM절에서 사용해 OUTER조인으로 0~23의 정보가 모두 출력되도록 한다.
OUTER 조인으로 생성된 데이터에서 COUNT값은 양측에 존재하면 기본값, 그렇지 않으면 null값이 출력되는데
null값을 0으로 대체해주는 작업을 진행하면 된다.

*/