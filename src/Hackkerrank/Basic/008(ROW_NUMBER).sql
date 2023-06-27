/*
https://www.hackerrank.com/challenges/occupations/problem?isFullScreen=true



1. 메인 쿼리에서 출력해야할 정보
첫 번째 열 : 의사
두 번째 열 : 교수
세 번째 열 : 가수
네 번째 열 : 배우
모든 컬럼은 알파벳순으로 정렬

각 직업에서 최대 이름 수(인원)보다 적은 열은 NULL값을 채워 출력

2. 풀이를 위해, 각 직업별로 이름을 알파벳 순으로 정렬하여 각 행에 번호를 부여해야한다.
ROW_NUMBER() OVER (PARTITION BY Occupation ORDER BY Name)

-> 검색해서 찾은 정보

SQL에서 윈도우 함수 중 하나로, 결과 집합의 각 행에 번호를 부여하는 기능(번호는 정렬순서 및 파티션에 따라 부여됨)

ROW_NUMBER(): 각 행에 부여될 번호를 나타냅니다. 번호는 정수 형태로 표현되며, 각 행마다 유일한 값을 가집니다.

OVER: 함수가 적용될 윈도우(창)를 지정합니다. 윈도우는 ORDER BY 절과 PARTITION BY 절에 의해 정의됩니다.

PARTITION BY는 분할의 기준을 설정

ORDER BY는 SELECT문에서 사용되는것과 동일하게 정렬의 의미이다.

이 쿼리문을 해석하면 Occupation 열을 기준으로 분할하되 Name 열로 정렬하여 각 행마다 번호를 부여합니다.
이 번호를 GROUP BY에 사용해서 하나의 record에 직업별 이름이 나오도록 설정할 수 있도록 하는 것이다.


*/

SELECT MAX(CASE WHEN Occupation = 'Doctor' THEN Name END) AS DoctorName,
       MAX(CASE WHEN Occupation = 'Professor' THEN Name END) AS ProfessorName,
       MAX(CASE WHEN Occupation = 'Singer' THEN Name END) AS SingerName,
       MAX(CASE WHEN Occupation = 'Actor' THEN Name END) AS ActorName
FROM (
  SELECT Name, Occupation,
         ROW_NUMBER() OVER (PARTITION BY Occupation ORDER BY Name) AS rn
  FROM OCCUPATIONS
)
GROUP BY rn
ORDER BY rn;

/*
문제와 풀이를 같이
*/
