-- 코드를 입력하세요
SELECT O.ANIMAL_ID, O.NAME
from ANIMAL_OUTS as O
    left join ANIMAL_INS as I
    on O.ANIMAL_ID = I.ANIMAL_ID
where I.ANIMAL_ID is null;