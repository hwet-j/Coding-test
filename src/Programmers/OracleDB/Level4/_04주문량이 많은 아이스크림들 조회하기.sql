SELECT FLAVOR
FROM
    (
    SELECT a.FLAVOR FLAVOR, (a.ORD + b.ORD)
    FROM
        (SELECT FLAVOR , SUM(TOTAL_ORDER) ORD
        FROM FIRST_HALF
        GROUP BY FLAVOR) a
    FULL OUTER JOIN
        (SELECT FLAVOR , SUM(TOTAL_ORDER) ORD
        FROM JULY
        GROUP BY FLAVOR) b
    ON a.FLAVOR = b.FLAVOR
    ORDER BY 2 DESC
    )
WHERE ROWNUM <= 3


/*
7월 아이스크림 종류별 총 주문량
상반기의 아이스크림 종류별 총 주문량
두 개의 서브쿼리 작성하여 두 개의 쿼리문을 FULL OUTER JOIN으로 연결
( 정보가 한곳에만 존재해도 정보가 나와야하기 때문에 FULL OUTER JOIN )
판매량의 최대 3개의 데이터만 보여줘야하므로 위의 작성한 쿼리문을
판매량 순으로 정렬하고 다시 서브쿼리로 작성하고
이 데이터를 WHERE 절에서 위에서 3개의 데이터만 사용한다.
*/