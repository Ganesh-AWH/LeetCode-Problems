-- Last updated: 9/14/2025, 9:13:18 AM
# Write your MySQL query statement below
SELECT e.name,
       b.bonus
FROM employee e
LEFT JOIN bonus b
     USING(empId)
 WHERE b.bonus IS NULL OR b.bonus < 1000; 