-- Last updated: 9/14/2025, 9:13:16 AM
# Write your MySQL query statement below
SELECT name 
FROM customer
WHERE 
    referee_id is NULL OR referee_id != 2;