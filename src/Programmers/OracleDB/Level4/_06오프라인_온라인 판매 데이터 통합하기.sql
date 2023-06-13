SELECT SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM
((SELECT TO_CHAR(SALES_DATE, 'YYYY-MM-DD') SALES_DATE,  PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-03')
UNION ALL
(SELECT TO_CHAR(SALES_DATE, 'YYYY-MM-DD') SALES_DATE,  PRODUCT_ID, null USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-03'))
ORDER BY 1, 2, 3

/*
1. 온라인판매 기록에서 2022-03의 정보만 가져온다.
2. 오프라인판매 기록에서 2022-03의 정보만 가져온다.
3. UNION ALL을 사용해서 쿼리를 합쳐준다.
4. UNION ALL이 에러가 나는데, 두개의 컬럼이 달라서 발생하는 문제로 이를 해결한다.
4-1. 오프라인 기록에는 USER_ID가 존재하지 않는데 최종 데이터에서 사용하므로 null로 대체하여 입력한다.
4-2. 최종결과에 날짜의 형식이 년-월-일 이므로 형식도 맞춰서 입력해준다.
5. 3번을 다시 진행하고, ORDER BY로 정렬하면 끝
*/