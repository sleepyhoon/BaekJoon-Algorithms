with T as (
    select FOOD_TYPE, max(FAVORITES) as FAVORITES
    from REST_INFO
    group by FOOD_TYPE
)

SELECT R.FOOD_TYPE,R.REST_ID,R.REST_NAME,R.FAVORITES
from REST_INFO R
right join T
    on R.FAVORITES = T.FAVORITES and R.FOOD_TYPE = T.FOOD_TYPE
order by FOOD_TYPE desc;