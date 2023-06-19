/*
Query the list of CITY names from STATION which have vowels
(i.e., a, e, i, o, and u) as both their first and last characters.
Your result cannot contain duplicates.

city 컬럼이 a,e,i,o,u 로 시작하거나, 끝나는 모든 데이터를 가져오는 문제

*/

-- 1
SELECT DISTINCT CITY
FROM STATION
WHERE REGEXP_LIKE(LOWER(CITY),'^[aeiou]')
AND REGEXP_LIKE(LOWER(CITY),'[aeiou]$');

-- 2
SELECT DISTINCT CITY
FROM STATION
WHERE REGEXP_LIKE(LOWER(CITY), '^[aeiou].*[aeiou]$');

/*
1,2번 둘은 동일한 쿼리문이며, .* 를 통하여 AND 의 의미를 표할수 있다.

OR의 의미는 | 를 통해서 나타낸다.
*/
