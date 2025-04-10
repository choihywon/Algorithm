-- 코드를 입력하세요
SELECT MCDP_CD AS '진료과 코드', COUNT(DISTINCT PT_NO) AS '5월 예약건수'
FROM APPOINTMENT
WHERE APNT_YMD BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY MCDP_CD
ORDER BY COUNT(DISTINCT PT_NO), MCDP_CD;
