-- ──────────────────────────────────────────────────
-- Problem  : 3611. Find Overbooked Employees
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/find-overbooked-employees/
-- Runtime  : 643 ms (beats 46%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
WITH employee_hour AS (
SELECT employee_id, DATEDIFF(meeting_date , "1900-01-01") DIV 7 AS w, 
SUM(duration_hours) AS hours FROM meetings GROUP BY employee_id, w
),

employee_heavy AS (
SELECT employee_id, COUNT(*) AS meeting_heavy_weeks from employee_hour
WHERE hours > 20 GROUP BY employee_id
)



SELECT a.employee_id, a.employee_name, a.department, b.meeting_heavy_weeks 
FROM employees a, employee_heavy b WHERE a.employee_id = b.employee_id AND b.meeting_heavy_weeks > 1 ORDER BY b.meeting_heavy_weeks DESC, a.employee_name