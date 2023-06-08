SELECT CAR_TYPE, COUNT(OPTIONS) CARS
FROM CAR_RENTAL_COMPANY_CAR 
WHERE OPTIONS LIKE '%가죽시트%'
OR OPTIONS LIKE '%열선시트%'
OR OPTIONS LIKE '%통풍시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE


/*
WHERE 절에 LIKE 명령어를 사용해서 구해줬다.
*/