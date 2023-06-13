SELECT CAR_ID,
CASE MAX(AVAILABILITY_FORM)
WHEN 1 THEN '대여중'
ELSE '대여 가능'
END AS AVAILABILITY
FROM (SELECT CAR_ID, START_DATE, END_DATE,
CASE
WHEN '2022-10-16' BETWEEN TO_CHAR(START_DATE, 'YYYY-MM-DD') AND TO_CHAR(END_DATE, 'YYYY-MM-DD')  THEN 1
ELSE 0
END AS "AVAILABILITY_FORM"
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY)
GROUP BY CAR_ID
ORDER BY CAR_ID DESC



/*
☆☆☆☆☆ - 어려웠음..

모든 CAR_ID중 2022년 10월 16일에 자동차가 대여가능하면 대여가능, 그렇지않으면 대여중으로 작성한다.

CAR_ID 별 자동차 대여 기록이 여러개를 가지는데 이 데이터 중 한번이라도 해당기간을 포함하면 대여중이다.

서브 쿼리를 통해 해당기간을 포함하면 1, 그렇지않으면 0이라는 새로운 컬럼(AVAILABILITY_FORM)을 생성한다.

쿼리문에서 서브쿼리를 통해 만들어진 데이터를 CAR_ID로 묶어서 AVAILABILITY_FORM 의 최대값을 확인하여

최대값이 1이면 대여중, 최대값이 0이면 대여 가능으로 출력하도록 한다.

*/