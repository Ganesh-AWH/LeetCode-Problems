# Write your MySQL query statement below

-- cross join

-- b is end and a is start 
SELECT a.machine_id, 
       ROUND(AVG(b.timestamp - a.timestamp), 3) AS processing_time
FROM activity a, activity b
WHERE 
    a.machine_id = b.machine_id AND
    a.process_id = b.process_id AND
    a.activity_type = 'start' AND
    b.activity_type = 'end'
GROUP BY machine_id;