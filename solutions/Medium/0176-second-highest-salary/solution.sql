-- ──────────────────────────────────────────────────
-- Problem  : 176. Second Highest Salary
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/second-highest-salary/
-- Runtime  : 313 ms (beats 40%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 perarasu1108. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

select
(select distinct Salary 
from Employee order by salary desc 
limit 1 offset 1) 
as SecondHighestSalary;
