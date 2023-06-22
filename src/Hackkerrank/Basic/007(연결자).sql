/*
https://www.hackerrank.com/challenges/the-pads/problem?isFullScreen=true

1. 알파벳 정렬 모든 이름을
이름 뒤에는 각 직업의 첫글자가 괄호안에 작성되게 한다.

2.
각 직업별로 몇명이 있는지 출력
직업별 인원으로 정렬하고 동일할 시에 알파벳순으로 정렬

두 개를 UNION ALL 로 합쳐주는 문제인줄 알았으나 그냥 두개의 쿼리문을 작성하는 문제였음.
*/

SELECT name || '(' || SUBSTR(occupation,1,1) || ')'
FROM occupations
ORDER BY name;

SELECT 'There are a total of ' || COUNT(name) || ' ' || LOWER(occupation) || 's.'
FROM occupations
GROUP BY occupation
ORDER BY COUNT(name), occupation;

/*
1. SUBSTR을 통해서 직업의 가장 처음 문자를 추출
2. LOWER 을 통해서 직업을 소문자로 변경해야하며 뒤에 s 를 붙여야 정답처리임 (예시에 나온 형식에 맞게 )
2-1. 직업별 인원을 파악해야 하므로 GROUP BY 에 occupation, 정렬은 인원수, 직업명으로 한다.

*/
