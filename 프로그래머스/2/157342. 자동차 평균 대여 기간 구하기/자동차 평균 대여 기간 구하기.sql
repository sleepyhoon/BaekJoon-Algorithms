-- 코드를 입력하세요
# SELECT CAR_ID,	AVERAGE_DURATION

select CAR_ID, round(avg(DATEDIFF(END_DATE , START_DATE) + 1),1) as AVERAGE_DURATION 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
    having round(avg(DATEDIFF(END_DATE , START_DATE) + 1),1) >= 7
order by 2 desc, 1 desc;