/*
Query the list of CITY names from
STATION that do not start with vowels.
Your result cannot contain duplicates.

city 컬럼이 a,e,i,o,u 로 시작하지 않는 데이터만

*/


SELECT DISTINCT CITY
FROM STATION
WHERE REGEXP_LIKE(LOWER(CITY),'^[^aeiou]')

/*
[] 내부에 ^ 의 의미는 부정을 의미한다. 고로 aeiou를 제외한 데이터를 의미함

*/
