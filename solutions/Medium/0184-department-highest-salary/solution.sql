-- ──────────────────────────────────────────────────
-- Problem  : 184. Department Highest Salary
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/department-highest-salary/
-- Runtime  : 848 ms (beats 46%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT Department.name AS Department ,Employee.name AS Employee, Employee.salary
FROM Department  JOIN Employee  ON Employee.departmentId=Department.id 
WHERE(departmentId, salary) IN
(SELECT departmentId,MAX(salary) FROM Employee GROUP BY departmentId) ;