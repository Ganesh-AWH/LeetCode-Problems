-- Last updated: 9/14/2025, 9:09:37 AM
# Write your MySQL query statement below
SELECT customer_id,
       COUNT(*) AS count_no_trans
FROM visits 
WHERE visit_id NOT IN(
    SELECT visit_id
    FROM transactions
)
GROUP BY customer_id;