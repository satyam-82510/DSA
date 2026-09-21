# Write your MySQL query statement below
SELECT NAME 
FROM CUSTOMER
WHERE referee_id != 2 or referee_id is null;
#fastest
#select name from customer where referee_id != 2 or referee_id is null;