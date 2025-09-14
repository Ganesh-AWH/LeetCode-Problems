-- Last updated: 9/14/2025, 9:10:09 AM
# Write your MySQL query statement below
SELECT eui.unique_id, e.name
FROM employees e
LEFT JOIN employeeuni eui
    USING (id);