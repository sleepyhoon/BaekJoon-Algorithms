-- 코드를 입력하세요
SELECT B.CATEGORY, sum(S.SALES) as TOTAL_SALES
from book as B
    left join book_sales as S
    on B.BOOK_ID = S.BOOK_ID and year(S.SALES_DATE) = 2022 and month(S.SALES_DATE) = 1
group by B.CATEGORY
order by B.CATEGORY asc;