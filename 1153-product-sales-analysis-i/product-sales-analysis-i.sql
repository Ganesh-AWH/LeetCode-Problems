# Write your MySQL query statement below
SELECT p.product_name,
       s.year,
       s.price
FROM sales s
JOIN product p
    USING (product_id);