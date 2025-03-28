SELECT CONCAT('/home/grep/src/', B.BOARD_ID, '/', B.FILE_ID, B.FILE_NAME, B.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE AS B
JOIN USED_GOODS_BOARD as T ON T.BOARD_ID = B.BOARD_ID
where T.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY B.FILE_ID DESC;