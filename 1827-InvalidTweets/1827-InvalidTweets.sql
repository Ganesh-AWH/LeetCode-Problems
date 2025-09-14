-- Last updated: 9/14/2025, 9:09:21 AM
# Write your MySQL query statement below
SELECT tweet_id
FROM  tweets
WHERE LENGTH(content) > 15;