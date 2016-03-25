-- author: Ann Huang
-- 02/19/2016
-- compare two tables items and things, return unique records

SELECT  'items' AS `set`, i.*
FROM    items i
WHERE   ROW(i.name, i.price, i.quantity) NOT IN
        (
        SELECT  *
        FROM    things
        )
UNION ALL
SELECT  'things' AS `set`, t.*
FROM    things t
WHERE   ROW(t.name, t.price, t.quantity) NOT IN
        (
        SELECT  *
        FROM    items
        );