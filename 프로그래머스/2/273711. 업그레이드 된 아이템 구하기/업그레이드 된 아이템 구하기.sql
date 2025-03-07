with T as 
(select T.ITEM_ID
from ITEM_TREE T, ITEM_INFO I
where T.PARENT_ITEM_ID = I.ITEM_ID and I.RARITY = "RARE")

select I.ITEM_ID, I.ITEM_NAME,	I.RARITY
from ITEM_INFO as I
join T
    on I.ITEM_ID = T.ITEM_ID
order by I.ITEM_ID desc;