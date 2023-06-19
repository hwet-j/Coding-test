/*
Query a list of CITY names from STATION
for cities that have an even ID
number. Print the results in any order,
but exclude duplicates from the answer.

CITY의 ID값이 짝수인 데이터만 출력하며 CITY의 이름이 중복을 제외하고 출력하는 문제이다.

*/

SELECT DISTINCT(city)
FROM station
WHERE MOD(id,2) = 0;


/*
중복을 제거하는 DISTINCT와
나머지를 구하는 MOD 함수를 사용하여 해결
*/

