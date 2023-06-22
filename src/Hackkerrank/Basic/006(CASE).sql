/*
https://www.hackerrank.com/challenges/what-type-of-triangle/problem?isFullScreen=true

3개의 컬럼 값을 확인하여 정삼각형, 이등변삼각형, 그냥삼각형, 삼각형이아님 으로 설정하는 문제
*/

SELECT CASE
WHEN A + B <= C THEN 'Not A Triangle'
WHEN B + C <= A THEN 'Not A Triangle'
WHEN A + C <= B THEN 'Not A Triangle'
WHEN A = B AND B = C THEN 'Equilateral'
WHEN A = B AND B != C THEN 'Isosceles'
WHEN B = C AND A != B THEN 'Isosceles'
WHEN A = C AND B != C THEN 'Isosceles'
ELSE 'Scalene'
END
FROM triangles;

/*
CASE 문을 사용해서 작성했으며 위에서 부터 순차적으로 진행되기 때문에 먼저 걸러야 할 조건부터 작성한다.

1. 삼각형이 아닌 데이터인지 확인한다.
1-1. 해당 조건을 뒤에 작성하면 길이가 두변의 길이의 합이 한변의 길이와 같거나 하는 상황에서 이등변 삼각형으로 잘못 인식할 수 있다.
2. 정삼각형인지 확인한다. (이등변 삼각형의 조건이 먼저오면 정삼각형도 이등변삼각형으로 인식)
3. 이등변삼각형인지 확인한다.
4. 나머지는 그냥 삼각형

*/
