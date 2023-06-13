SELECT CATEGORY, MAX(PRICE), PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
GROUP BY CATEGORY, PRODUCT_NAME
HAVING MAX(PRICE) IN
(
SELECT MAX(PRICE)
FROM FOOD_PRODUCT
GROUP BY CATEGORY
)
ORDER BY MAX(PRICE) DESC

/*
메인 쿼리의 CATEGORY가 '과자', '국', '김치', '식용유'인 데이터만 사용하고,
CATEGORY, PRODUCT_NAME 로 묶어주며 HAVING절에서 가격의 최대값만 출력하도록 최대가격이
서브쿼리로 만들어준 최대가격에 있는 데이터에 존재할 경우인 정보만 사용

더 쉽고 가독성 좋은 쿼리문이 작성가능할거 같다.
*/