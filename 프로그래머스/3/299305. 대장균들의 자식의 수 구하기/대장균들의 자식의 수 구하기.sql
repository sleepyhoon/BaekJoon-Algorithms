with A as (select ID from ECOLI_DATA)

select A.ID, count(T.PARENT_ID) as CHILD_COUNT
from A
left join ECOLI_DATA T
    on T.PARENT_ID = A.ID
group by A.ID
order by A.ID;