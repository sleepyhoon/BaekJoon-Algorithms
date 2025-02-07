select year(B.DIFFERENTIATION_DATE) as YEAR, A.BIG - B.SIZE_OF_COLONY as YEAR_DEV, B.ID
from ECOLI_DATA as B
    join (select year(DIFFERENTIATION_DATE) as YEARs, max(SIZE_OF_COLONY) as BIG
        from ECOLI_DATA
        group by year(DIFFERENTIATION_DATE)
    ) A on A.YEARs = year(B.DIFFERENTIATION_DATE)
order by YEAR, YEAR_DEV;