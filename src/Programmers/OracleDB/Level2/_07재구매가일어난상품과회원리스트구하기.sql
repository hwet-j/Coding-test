-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID FROM
(SELECT USER_ID, PRODUCT_ID, COUNT(PRODUCT_ID) AS CNTNUM
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID)
WHERE CNTNUM > 1
ORDER BY USER_ID, PRODUCT_ID DESC


/*
서브쿼리를 사용하여 유저별 동일한 상품을 구매한 개수를 구해주고
서브쿼리를 통해 주어진 데이터를 통하여 구매 개수가 1초과인 정보만 출력한다.
*/
