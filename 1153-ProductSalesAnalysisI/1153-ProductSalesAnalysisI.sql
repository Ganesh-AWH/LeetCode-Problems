-- Last updated: 9/14/2025, 9:11:05 AM
# Write your MySQL query statement below
SELECT p.product_name,
       s.year,
       s.price
FROM sales s
JOIN product p
    USING (product_id);