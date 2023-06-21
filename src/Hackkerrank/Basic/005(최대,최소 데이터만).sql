/*
https://www.hackerrank.com/challenges/weather-observation-station-5/problem?isFullScreen=true

CITY 이름이 가장 짧은 가장 긴 두 개의 도시를 출력하고 그들의 각각의 길이도 같이 출력해라

만약 동일한 길이의 데이터가 하나보다 많다면 도시 이름을 알파벳 순으로 정렬했을때 먼저 오는 것을 출력해라.
*/

SELECT city, LENGTH(city)
FROM station
WHERE city IN (
    (SELECT city
    FROM (SELECT city
    FROM station
    ORDER BY LENGTH(city), city)
    WHERE rownum = 1)
    ,
    (SELECT city
    FROM (SELECT city
    FROM station
    ORDER BY LENGTH(city) DESC, city)
    WHERE rownum = 1)
);

/*
FETCH 를 사용하면 편리하지만, FETCH는 오라클 12버전 이후부터 사용가능한데
해커랭크는 12버전을 사용하는 듯 하다. 계속 잘못된 문장 또는 문장이 끝나지 않았다고 하여 rownum을 사용해서 풀이한다.

1. 도시명을 길이, 알파벳별로 정렬한 서브쿼리문을 두 개 작성한다.
1-1. 하나는 최대길이가 제일위로 정렬되도록 한다.
1-2. 다른 하나는 최소길이가 제일 위로 정렬되도록 한다.
1-3. 두 쿼리문은 동일한 길이가 있을 수 있으니 city 명으로 정렬해준다.
2. 서브쿼리에서 정렬된 데이터에서 가장 첫번째 데이터(city이름) 을 각각 가져온다.
3. 메인 쿼리에서 WHERE 절에서 2번에서 가져온 두 개의 데이터를 사용한다.

0. 2번에서 쿼리문 city명만 가져오지 않고 데이터 전체를 가져와 두 개의 데이터를 UNION 해주는 방법도있다.

*/
