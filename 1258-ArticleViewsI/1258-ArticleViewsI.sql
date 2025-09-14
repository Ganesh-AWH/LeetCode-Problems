-- Last updated: 9/14/2025, 9:10:51 AM
# Write your MySQL query statement below
SELECT DISTINCT author_id AS id
FROM views 
WHERE author_id = viewer_id
ORDER BY author_id;