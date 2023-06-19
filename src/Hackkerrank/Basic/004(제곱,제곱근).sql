/*
Consider P1(a,b) and P2(c,d) to be two points on a 2D plane where (a,b) are
the respective minimum and maximum values of Northern Latitude
(LAT_N) and (c,d) are the respective
minimum and maximum values of Western Longitude (LONG_W) in STATION

두 사이의 거리를 유클리디안 거리로 계산하고, 소수점 4자리수까지 표현해라
*/


SELECT ROUND(SQRT(POWER(MAX(lat_n) - MIN(lat_n), 2) + POWER(MAX(long_w) - MIN(long_w),2)),4)
FROM station;

/*
POWER을 사용하여 해당 표현식에 대한 제곱이 가능하며
SQRT를 사용해서 제곱근이 가능하다.

간단하지만 알고있으면 좋을듯한 함수

*/
