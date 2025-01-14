-- 코드를 입력하세요
SELECT I.NAME, I.DATETIME
from ANIMAL_INS as I
where I.ANIMAL_ID not in (select O.ANIMAL_ID from ANIMAL_OUTS as O)
order by I.datetime asc
limit 3;