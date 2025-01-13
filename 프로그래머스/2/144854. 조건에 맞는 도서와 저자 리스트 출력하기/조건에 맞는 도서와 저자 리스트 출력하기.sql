-- 코드를 입력하세요
SELECT BOOK_ID,	AUTHOR_NAME, date_format(PUBLISHED_DATE,'%Y-%m-%d')
from book as b
    left join author as a
    on a.author_id = b.author_id
where CATEGORY = '경제'
order by PUBLISHED_DATE asc;
    