SELECT CATEGORY, SUM(SALES)
FROM BOOK b JOIN BOOK_SALES s
ON b.BOOK_ID = s.BOOK_ID
WHERE TO_CHAR(s.SALES_DATE, 'YYYY-MM') = '2022-01'
GROUP BY b.CATEGORY
ORDER BY b.CATEGORY



/*
BOOK, BOOK_SALES 를 JOIN 해주고 2022년 1월에 판매된 데이터만 추출 하기 위해
TO_CHAR 함수를 사용, 카테고리(CATEGORY) 별로 묶어서 판매 개수를 계산하므로 GROUP BY 해준다.
총 판매량(TOTAL_SALES) 을 구해주기 위해 카테고리별 SUM함수를 사용해 SALES를 더해준다.
마지막으로 카테고리 이름으로 정렬
*/
