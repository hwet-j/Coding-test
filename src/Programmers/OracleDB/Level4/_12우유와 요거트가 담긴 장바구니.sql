SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME = 'Yogurt'
INTERSECT
SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME = 'Milk'


/*
교집합(INTERSECT)을 사용해서 풀이
*/