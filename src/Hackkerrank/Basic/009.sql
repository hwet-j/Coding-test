/*
https://www.hackerrank.com/challenges/binary-search-tree-1/problem?isFullScreen=true


최상단 - 부모가 없는 숫자
Root

최하단 - 자식이 없는 숫자
Leaf

나머지는
Inner

P에 없고 N에만 있으면 최하단

SELECT N
FROM BST
WHERE N NOT IN(
SELECT DISTINCT P FROM BST WHERE P IS NOT NULL);


N과 맵핑되는 P값이 null이면 최상단

SELECT N
FROM BST
WHERE P IS NULL;


*/

SELECT DISTINCT N, CASE
WHEN N in
(SELECT N
FROM BST
WHERE P IS NULL)
THEN 'Root'
WHEN N IN
(SELECT N
FROM BST
WHERE N NOT IN(
SELECT DISTINCT P FROM BST WHERE P IS NOT NULL))
THEN 'Leaf'
ELSE 'Inner'
END
FROM BST
ORDER BY 1;
