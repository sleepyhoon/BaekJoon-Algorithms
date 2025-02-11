-- 코드를 입력하세요
with recursive cte (n) 
as (
    select 0
    union all
    select n+1
    from cte
    where n < 23
),

A as (
    select hour(DATETIME) as H, count(*) as C
    from ANIMAL_OUTS
    group by H
)

SELECT cte.n AS HOUR, COALESCE(A.C, 0) AS count
from cte
    left join A on cte.n = A.H
order by HOUR;