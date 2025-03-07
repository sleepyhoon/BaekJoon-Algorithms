select distinct(D.ID), D.EMAIL, D.FIRST_NAME, D.LAST_NAME
from DEVELOPERS D
join SKILLCODES S
    on D.SKILL_CODE & S.CODE
    where S.NAME = "Python" or S.NAME = "C#"
order by ID;