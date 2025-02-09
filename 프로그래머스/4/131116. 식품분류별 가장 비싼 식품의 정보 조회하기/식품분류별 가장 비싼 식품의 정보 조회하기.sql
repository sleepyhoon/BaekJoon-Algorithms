-- 코드를 입력하세요
SELECT CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where (
    CATEGORY = "과자" and PRICE = (SELECT max(PRICE) as MAX_PRICE from FOOD_PRODUCT where CATEGORY = "과자")) 
    or (
    CATEGORY = "국" and PRICE = (SELECT max(PRICE) as MAX_PRICE from FOOD_PRODUCT where CATEGORY = "국"))
    or (
    CATEGORY = "김치" and PRICE = (SELECT max(PRICE) as MAX_PRICE from FOOD_PRODUCT where CATEGORY = "김치"))
    or (CATEGORY = "식용유" and PRICE = (SELECT max(PRICE) as MAX_PRICE from FOOD_PRODUCT where CATEGORY = "식용유"))
group by CATEGORY
order by MAX_PRICE desc;

# SELECT CATEGORY, max(PRICE) as MAX_PRICE
# from FOOD_PRODUCT
# where CATEGORY = "과자";
# SELECT CATEGORY, max(PRICE) as MAX_PRICE
# from FOOD_PRODUCT
# where CATEGORY = "국";
# SELECT CATEGORY, max(PRICE) as MAX_PRICE
# from FOOD_PRODUCT
# where CATEGORY = "김치";
# SELECT CATEGORY, max(PRICE) as MAX_PRICE
# from FOOD_PRODUCT
# where CATEGORY = "식용유";
